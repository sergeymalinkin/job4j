package ru.job4j.tracker;

public class FindItemByName implements UserAction {
    private int key;
    private String info;

    FindItemByName(int key, String info) {
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
        System.out.println("------------ Поиск заявки по имени --------------");
        System.out.println("------------------ Результат --------------------");
        String key = input.ask("Введите имя заявки, для ее поиска :");
        Item[] items = tracker.findByName(key);
        if (items != null) {
            for (Item item : tracker.findByName(key)) {
                System.out.println(item); }
            System.out.println("-------------------------------------------------");
        }
    }
}
