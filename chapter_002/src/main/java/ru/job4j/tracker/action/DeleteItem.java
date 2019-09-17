package ru.job4j.tracker.action;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;
/**
 * Действие - удаление заявки.
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 2.0
 * @since 17.09.2019.
 */
public class DeleteItem extends BaseAction {
    private final Consumer<String> output;
    public DeleteItem(int key, String info, Consumer<String> output) {
        super(key, info);
        this.output = output;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("----------------- Удаление заявки -----------------");
        if (tracker.delete(input.ask("Введите Id заявки, для ее удаления :"))) {
        output.accept("--------------- Заявка удалена ----------------");
        } else {
            output.accept("-------------- Заявка не удалена!--------------");
        }
    }
}

