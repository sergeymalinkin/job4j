package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.tracker.Item;
import ru.job4j.tracker.tracker.Tracker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenDeleteNameThenReturnNewSize() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription");
        Item second = new Item("test2", "testDescription2");
        tracker.add(first);
        tracker.add(second);
        tracker.delete(second.getId());
        Item result = tracker.findById(first.getId());
        assertThat(result.getName(), is(first.getName()));
    }
    @Test
    public void whenGetNameThenReturnThisName() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription");
        Item second = new Item("test2", "testDescription2");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findByName(first.getName())[0];
        assertThat((result), is(first));
    }

}
