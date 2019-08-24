package ru.job4j.tracker;

public class FindItemById implements UserAction {
    private int key;
    private String info;

    FindItemById(int key, String info) {
        this.key = key;
        this.info = info;
    }
    @Override
    public int key() {
        return this.key;
    }
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.info);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по ID -----------------");
        System.out.println("------------------ Результат --------------------");
        String id = input.ask("Введите Id заявки, для ее поиска :");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
            System.out.println("-------------------------------------------------");
        } else {
            System.out.println("-------------- Заявка не найдена!--------------");
        }
    }
}
