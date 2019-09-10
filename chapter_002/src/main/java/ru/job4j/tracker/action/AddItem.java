package ru.job4j.tracker.action;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;
public class AddItem extends BaseAction {
    private final Consumer<String> output;
    public AddItem(int key, String info, Consumer<String> output) {
        super(key, info);
        this.output = output;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("-------- Добавление новой заявки ----------");
        String name = input.ask("Пожалуйста, введите имя заявки:");
        String desc = input.ask("Пожалуйста, введите описание заявки:");
        Item item = new Item(name, desc);
        tracker.add(item);
        output.accept("Новая заявка с Id: " + item.getId() + " " + "добавлена!");
    }
}