package ru.job4j.tracker;
import java.util.function.Consumer;
public class DeleteItem extends BaseAction {
    private final Consumer<String> output;
    DeleteItem(int key, String info, Consumer<String> output) {
        super(key, info);
        this.output = output;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("----------------- Удаление заявки -----------------");
        String id = input.ask("Введите Id заявки, для ее удаления :");
        if (tracker.delete(id)) {
            output.accept("--------------- Заявка удалена ----------------");
        } else {
            output.accept("-------------- Заявка не удалена!--------------");
        }
    }
}

