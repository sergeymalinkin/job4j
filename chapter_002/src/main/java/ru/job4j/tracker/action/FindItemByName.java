package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

import java.util.List;
import java.util.function.Consumer;
public class FindItemByName extends BaseAction {
    private final Consumer<String> output;
    public FindItemByName(int key, String info, Consumer<String> output) {
        super(key, info);
        this.output = output;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        boolean found = false;
        List<Item> items = tracker.findByName(input.ask("Введите имя заявки, для ее поиска :"));
        output.accept("----------- Поиск заявки по имени -----------");
        for (Item item : items) {
        if (item != null) {
            output.accept("Результат:");
            output.accept("ID заявки:   |" + item.getId() + '\n' + '\r'
                    +
                    "Имя заявки:  |" + item.getName() + '\n' + '\r'
                    +
                    "Описание:    |" + item.getDesc());
            found = true;
            break;
        }
        }
        if (!found) {
            output.accept("Результат:");
            output.accept("----------- Заявка не найдена! --------------");
            }
        }
}
