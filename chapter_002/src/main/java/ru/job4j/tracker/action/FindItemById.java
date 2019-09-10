package ru.job4j.tracker.action;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 3.0
 * @since 05.09.2019.
 */
public class FindItemById extends BaseAction {
    private final Consumer<String> output;
    public FindItemById(int key, String info, Consumer<String> output) {
        super(key, info);
        this.output = output;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("----------- Поиск заявки по ID----------- ");

        Item item = tracker.findById(input.ask("Введите Id заявки, для ее поиска :"));
        if (item != null) {
            output.accept("Результат:");
            output.accept(
                    "ID заявки:   |" + item.getId() + '\n' + '\r'
                            +
                            "Имя заявки:  |" + item.getName() + '\n' + '\r'
                            +
                            "Описание:    |" + item.getDesc());
        } else {
           output.accept("----------- Заявка не найдена! --------------");
        }
    }
}