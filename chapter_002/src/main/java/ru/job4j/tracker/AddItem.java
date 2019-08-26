package ru.job4j.tracker;

public class AddItem implements UserAction {
    private int key;
    private String info;

    @Override
    public int key() {
        return this.key;
    }
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.info);
    }

    AddItem(int key, String info) {
        this.key = key;
        this.info = info;
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