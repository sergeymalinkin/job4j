package ru.job4j.tracker;
import java.util.function.Consumer;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 3.0
 * @since 05.09.2019.
 */
public class FindItemById extends BaseAction {
    private final Consumer<String> output;
    FindItemById(int key, String info, Consumer<String> output) {
        super(key, info);
        this.output = output;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("------------ Поиск заявки по ID -----------------");
        output.accept("------------------ Результат --------------------");
        String id = input.ask("Введите Id заявки, для ее поиска :");
        Item item = tracker.findById(id);
        if (item != null) {
            output.accept("-------------------------------------------------");
        } else {
            output.accept("-------------- Заявка не найдена!--------------");
        }
    }
}