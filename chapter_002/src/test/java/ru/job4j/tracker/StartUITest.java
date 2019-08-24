package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicReference;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final static String SPLIT_LINE = System.lineSeparator();
    private final static String MENU =
                    "0. Добавление новой заявки" + SPLIT_LINE
                    +
                    "1. Отобразить все заявки" + SPLIT_LINE
                    +
                    "2. Замена заявки" + SPLIT_LINE
                    +
                    "3. Удаление заявки" + SPLIT_LINE
                    +
                    "4. Поиск заявки по ID" + SPLIT_LINE
                    +
                    "5. Поиск заявки по имени" + SPLIT_LINE
                    +
                    "6. Выход";
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
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc1"));
        Input input = new StubInput(new String[]{"1", "6"});
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
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker);
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    @Test
    public void whenUserDeleteItemThenTrackerDeleteItem() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("test1", "desc1"));
        new AtomicReference<>(tracker.add(new Item("test2", "desc2")));
        Input input = new StubInput(new String[]{"3", first.getId(), "6"});
        new StartUI(input, tracker);
        assertThat(tracker.findAll()[0].getName(), is("test2"));
    }
    @Test
    public void whenUserFindsItemByIdThenTrackerFindsItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc1"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker);
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
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc1"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker);
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
