package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 3.0
 * @since 05.09.2019.
 */
public class StartUITest {
    private Tracker tracker = new Tracker();
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final static String SPLIT_LINE = System.lineSeparator();
    private final static String MENU =
            "0 : Добавление новой заявки" + SPLIT_LINE
                    +
                    "1 : Отобразить все заявки" + SPLIT_LINE
                    +
                    "2 : Замена заявки" + SPLIT_LINE
                    +
                    "3 : Удаление заявки" + SPLIT_LINE
                    +
                    "4 : Поиск заявки по ID" + SPLIT_LINE
                    +
                    "5 : Поиск заявки по имени" + SPLIT_LINE
                    +
                    "6 : Выход";
    @Before
    public void loadOutputBefore() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutputAfter() {
        System.setOut(this.stdout);
    }
    @Test
    public void whenShowAllItem() {
        Item item = tracker.add(new Item("test1", "desc1"));
        List<String> list = new ArrayList<>();
        Input input = new StubInput(list);
        list.add("1");
        list.add("6");
        new StartUI(input, tracker);
        String sb = MENU + SPLIT_LINE
                +
                "------------ Отобразить все заявки -----------------" + SPLIT_LINE
                +
                "------------------ Результат ----------------------" + SPLIT_LINE
                +
                item.toString() + SPLIT_LINE
                +
                "---------------------------------------------------" + SPLIT_LINE
                +
                MENU + SPLIT_LINE;
        assertThat(out.toString(), is(sb));
    }
    @Test
    public void whenUpdateThenTrackerHasUpdatedItem() {
        Item item = this.tracker.add(new Item("test1", "desc1"));
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add(item.getId());
        list.add("test replace");
        list.add("updated");
        list.add("6");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker);
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    @Test
    public <delete> void whenUserDeleteItemThenTrackerDeleteItem() {
        Item item = tracker.add(new Item("test1", "desc1"));
        List<String> list = new ArrayList<>();
        list.add("3");
        list.add(item.getId());
        list.add("6");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker);
        Item deleteItem = null;
        assertThat(tracker.findById(item.getId()), is((delete) null));
    }
    @Test
    public void whenUserFindsItemByIdThenTrackerFindsItem() {
        Item item = tracker.add(new Item("test1", "desc1"));
        List<String> list = new ArrayList<>();
        list.add("4");
        list.add(item.getId());
        list.add("6");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker);
        String sb = MENU + SPLIT_LINE
                +
                "------------ Поиск заявки по ID -----------------" + SPLIT_LINE
                +
                "------------------ Результат --------------------" + SPLIT_LINE
                +
                item.toString() + SPLIT_LINE
                +
                "-------------------------------------------------" + SPLIT_LINE
                +
                MENU + SPLIT_LINE;
        assertThat(out.toString(), is(sb));
    }
    @Test
    public void whenFindItemByName() {
        Item item = tracker.add(new Item("test1", "desc1"));
        List<String> list = new ArrayList<>();
        list.add("5");
        list.add(item.getName());
        list.add("6");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker);
        String sb = MENU + SPLIT_LINE
                +
                "------------ Поиск заявки по имени --------------" + SPLIT_LINE
                +
                "------------------ Результат --------------------" + SPLIT_LINE
                +
                item.toString() + SPLIT_LINE
                +
                "-------------------------------------------------" + SPLIT_LINE
                +
                MENU + SPLIT_LINE;
        assertThat(out.toString(), is(sb));
    }
}