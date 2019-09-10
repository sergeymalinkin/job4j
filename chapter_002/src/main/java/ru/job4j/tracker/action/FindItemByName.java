package ru.job4j.tracker.action;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.ArrayList;
import java.util.function.Consumer;
public class FindItemByName extends BaseAction {
    private final Consumer<String> output;
    public FindItemByName(int key, String info, Consumer<String> output) {
        super(key, info);
        this.output = output;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("------------ Поиск заявки по имени --------------");
        System.out.println("------------------ Результат --------------------");
        String key = input.ask("Введите имя заявки, для ее поиска :");
        ArrayList<Item> items = tracker.findByName(key);
        if (items != null) {
            for (Item item : items) {
                System.out.println("-------------------------------------------------");
            }
        }
    }
}