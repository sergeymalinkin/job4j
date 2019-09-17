package ru.job4j.tracker.action;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;
/**
 * Действие - показать заявки.
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 2.0
 * @since 17.09.2019.
 */
public class ShowItems extends BaseAction {
    private final Consumer<String> output;
    public ShowItems(int key, String info, Consumer<String> output) {
        super(key, info);
        this.output = output;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            output.accept("--------- Показать все заявки -----------");
            output.accept("Результат:");
            output.accept(
                    "ID заявки:   |" + item.getId() + '\n' + '\r'
                            +
                            "Имя заявки:  |" + item.getName() + '\n' + '\r'
                            +
                            "Описание:    |" + item.getDesc());
        }
    }
}

