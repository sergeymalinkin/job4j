package ru.job4j.tracker;
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
        tracker.findAll();
        output.accept("---------------------------------------------------");
    }
}

