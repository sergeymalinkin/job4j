package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;
/**
 * Действие - редактирование заявки.
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 2.0
 * @since 17.09.2019.
 */
public class EditItem extends BaseAction {
    private final Consumer<String> output;
    public EditItem(int key, String info, Consumer<String> output) {
        super(key, info);
        this.output = output;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("------------- Замена заявки ---------------");
        String id = input.ask("Введите Id заявки, для ее изменения :");
        String name = input.ask("Введите новое имя заявки :");
        String desc = input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            output.accept("------------ Новая заявка с Id: " + item.getId() + " " + "заменена!");
        } else {
            output.accept("------------ Заявка не заменена!------------");
        }
    }
}