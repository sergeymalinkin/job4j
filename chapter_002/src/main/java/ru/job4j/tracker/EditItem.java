package ru.job4j.tracker;

public class EditItem extends BaseAction {
    EditItem(int key, String info) {
        super(key, info);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------- Замена заявки ---------------");
        String id = input.ask("Введите Id заявки, для ее изменения :");
        String name = input.ask("Введите новое имя заявки :");
        String desc = input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            System.out.println("------------- Заявка заменена --------------");
        } else {
            System.out.println("------------ Заявка не заменена!------------");
        }
    }
}