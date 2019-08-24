package ru.job4j.tracker;

public class ShowItems implements UserAction {
    private int key;
    private String info;

    ShowItems(int key, String info) {
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
        System.out.println("------------ Отобразить все заявки -----------------");
        System.out.println("------------------ Результат ----------------------");
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
        System.out.println("---------------------------------------------------");
    }
}

