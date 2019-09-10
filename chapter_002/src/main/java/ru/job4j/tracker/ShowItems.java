package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.function.Consumer;
public class ShowItems extends BaseAction {
    private final Consumer<String> output;
    ShowItems(int key, String info, Consumer<String> output) {
        super(key, info);
        this.output = output;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("------------ Отобразить все заявки -----------------");
        output.accept("------------------ Результат ----------------------");
        ArrayList<Item> all = tracker.findAll();
        for (Item item : all)
        output.accept(item.toString());
        output.accept("---------------------------------------------------");
    }
}

