package ru.job4j.tracker;

public class AddItem extends BaseAction {
    AddItem(int key, String info) {
        super(key, info);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Пожалуйста, введите имя заявки:");
        String desc = input.ask("Пожалуйста, введите описание заявки:");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("------------ Новая заявка с Id: " + item.getId() + " " + "добавлена!");
    }
}