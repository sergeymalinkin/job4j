package ru.job4j.tracker.action;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;
/**
 * Действие - поиск заявки по ID.
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 2.0
 * @since 17.09.2019.
 */
public class FindItemById extends BaseAction {
    private final Consumer<String> output;
    public FindItemById(int key, String info, Consumer<String> output) {
        super(key, info);
        this.output = output;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("----------- Поиск заявки по ID -----------");

        Item item = tracker.findById(input.ask("Введите Id заявки, для ее поиска :"));
        if (item != null) {
            output.accept("Результат:");
            output.accept("----------- Заявка найдена! --------------");
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