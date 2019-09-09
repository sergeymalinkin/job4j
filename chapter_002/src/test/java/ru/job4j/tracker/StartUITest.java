package ru.job4j.tracker;
import org.junit.After;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
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
    private final Consumer<String> output = new Consumer<>() {
        @Override
        public void accept(String s) {
            stdout.println(s);
        }

        @Override
        public String toString() {
            return out.toString();
        }
    };
    @After
    public void backOutputAfter() {
        output.accept("execute after method");
    }
    private static String menu() {
        StringBuilder builder = new StringBuilder();
        String ln = System.lineSeparator();
        builder.append("0 : Добавление новой заявки");
        builder.append(ln);
        builder.append("1 : Отобразить все заявки");
        builder.append(ln);
        builder.append("3 : Удаление заявки");
        builder.append(ln);
        builder.append("4 : Поиск заявки по ID");
        builder.append(ln);
        builder.append("5 : Поиск заявки по имени");
        builder.append(ln);
        builder.append("6 : Выход");
        builder.append(ln);
        return builder.toString();
    }
    @Test
    public void whenShowAllItem() {
        Item item1 = tracker.add(new Item("test1", "desc1"));
        Item item2 = tracker.add(new Item("test2", "desc2"));
        Item item3 = tracker.add(new Item("test3", "desc3"));
        List<String> list = new ArrayList<>();
        Input input = new StubInput(list);
        list.add("1");
        list.add("6");
        new StartUI(input, this.tracker, this.output).init();
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        assertThat(this.tracker.findAll(), is(items));
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
        new StartUI(input, this.tracker, output).init();
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
        new StartUI(input, this.tracker, output).init();
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
        new StartUI(input, tracker, output).init();
    }
    @Test
    public void whenFindItemByName() {
        Item item = this.tracker.add(new Item("test name", "desc"));
        List<String> list = new ArrayList<>();
        list.add("5");
        list.add(item.getName());
        list.add("6");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker, output).init();
        List<Item> items = new ArrayList<>();
        items.add(item);
        assertThat(this.tracker.findByName(item.getName()), is(items));
    }
}
