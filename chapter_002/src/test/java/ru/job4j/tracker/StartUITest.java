package ru.job4j.tracker;
import org.junit.After;
import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
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
    private static final Object MENU = StartUITest.menu();
    private Tracker tracker = new Tracker();
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private String ln = System.lineSeparator();
    private final Consumer<String> output = new Consumer<>() {
        private PrintStream ps = new PrintStream(out);
        @Override
        public void accept(String s) {
            ps.println(s);
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
        builder.append("*********** МЕНЮ ***********");
        builder.append(ln);
        builder.append("0 : Добавление новой заявки");
        builder.append(ln);
        builder.append("1 : Отобразить все заявки");
        builder.append(ln);
        builder.append("2 : Замена заявки");
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
    /**
     * Тест добавления заявки.
     */
    @Test
    public void whenUserAddItem() {
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("test1");
        list.add("desc");
        list.add("6");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker, this.output).init();
        assertThat(this.tracker.findAll().get(0).getName(), is("test1"));
    }
    /**
     * Тест отображения всех заявок.
     */

    @Test
    public void whenShowAllItem() {
        StringBuilder builder = new StringBuilder();
        Item item1 = tracker.add(new Item("test1", "desc1"));
        Item item2 = tracker.add(new Item("test2", "desc2"));
        Item item3 = tracker.add(new Item("test3", "desc3"));
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("6");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker, this.output).init();
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        builder.append(MENU);
        builder.append("--------- Показать все заявки -----------").append(ln);
        builder.append("Результат:").append(ln);
        builder.append(item1.toString()).append(ln);
        builder.append("--------- Показать все заявки -----------").append(ln);
        builder.append("Результат:").append(ln);
        builder.append(item2.toString()).append(ln);
        builder.append("--------- Показать все заявки -----------").append(ln);
        builder.append("Результат:").append(ln);
        builder.append(item3.toString()).append(ln);
        builder.append(MENU);
        assertThat(this.output.toString(), is(builder.toString()));
    }
    /**
     * Тест замены заявок.
     */
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
    /**
     * Тест удаления заявки.
     */
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
    /**
     * Тест поиска заявки по ID.
     */
    @Test
    public void whenUserFindsItemByIdThenTrackerFindsItem() {
        StringBuilder builder = new StringBuilder();
        Item item = tracker.add(new Item("test1", "desc1"));
        List<String> list = new ArrayList<>();
        list.add("4");
        list.add(item.getId());
        list.add("6");
        Input input = new StubInput(list);
        new StartUI(input, tracker, output).init();
        List<Item> items = new ArrayList<>();
        items.add(item);
        builder.append(MENU);
        builder.append("----------- Поиск заявки по ID -----------").append(ln);
        builder.append("Результат:").append(ln);
        builder.append(item.toString()).append(ln);
        builder.append(MENU);
        assertThat(this.output.toString(), is(builder.toString()));
    }
    /**
     * Тест поиска заявки по имени.
     */
    @Test
    public void whenFindItemByName() {
        StringBuilder builder = new StringBuilder();
        Item item = this.tracker.add(new Item("test name", "desc"));
        List<String> list = new ArrayList<>();
        list.add("5");
        list.add(item.getName());
        list.add("6");
        Input input = new StubInput(list);
        new StartUI(input, this.tracker, output).init();
        List<Item> items = new ArrayList<>();
        items.add(item);
        builder.append(MENU);
        builder.append("----------- Поиск заявки по имени -----------").append(ln);
        builder.append("Результат:").append(ln);
        builder.append(item.toString()).append(ln);
        builder.append(MENU);
        assertThat(this.output.toString(), is(builder.toString()));
    }
}