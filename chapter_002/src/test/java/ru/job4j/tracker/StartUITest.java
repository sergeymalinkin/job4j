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
    private final static String MENU = "Меню" + SPLIT_LINE
            +
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
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
    @Test
    public void whenSelectAllThenTrackerShowItemFirstSecond() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("test1", "desc1"));
        Item second = tracker.add(new Item("test2", "desc2"));
        Input input = new StubInput(new String[]{"1",  first.getId(), "6"});
        new StartUI(input, tracker).init();
        Item[] result = {first, second};
        assertThat(tracker.findAll(), is(result));
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
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    @Test
    public void whenUserDeleteItemThenTrackerDeleteItem() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("test1", "desc1"));
        new AtomicReference<>(tracker.add(new Item("test2", "desc2")));
        Input input = new StubInput(new String[]{"3", first.getId(), "test delete", "удалили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test2"));
    }

    @Test
    public void whenUserFindsItemByIdThenTrackerFindsItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc1"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        StringBuilder sb = new StringBuilder();
        new StartUI(input, tracker).init();
        sb.append(MENU).append(SPLIT_LINE);
        sb.append("------------ Поиск заявки по ID -----------------").append(SPLIT_LINE);
        sb.append("------------------ Результат --------------------").append(SPLIT_LINE);
        sb.append(item.toString()).append(SPLIT_LINE);
        sb.append("------------------------------------------------").append(SPLIT_LINE);
        sb.append(MENU).append(SPLIT_LINE);
        assertThat(out.toString(), is(sb.toString()));
    }
    @Test
    public void whenFindByNameItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc1"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        StringBuilder sb = new StringBuilder();
        new StartUI(input, tracker).init();
        sb.append(MENU).append(SPLIT_LINE);
        sb.append("------------ Поиск заявки по имени --------------").append(SPLIT_LINE);
        sb.append("------------------ Результат --------------------").append(SPLIT_LINE);
        sb.append(item.toString()).append(SPLIT_LINE);
        sb.append("------------------------------------------------").append(SPLIT_LINE);
        sb.append(MENU).append(SPLIT_LINE);
        assertThat(out.toString(), is(sb.toString()));
    }
}
