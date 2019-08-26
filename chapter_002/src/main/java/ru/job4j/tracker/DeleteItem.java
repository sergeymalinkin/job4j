package ru.job4j.tracker;

public class DeleteItem extends BaseAction {
    DeleteItem(int key, String info) {
        super(key, info);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("----------------- Удаление заявки -----------------");
        String id = input.ask("Введите Id заявки, для ее удаления :");
        if (tracker.delete(id)) {
            System.out.println("--------------- Заявка удалена ----------------");
        } else {
            System.out.println("-------------- Заявка не удалена!--------------");
        }
    }
}

