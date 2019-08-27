package ru.job4j.tracker;

public class FindItemByName extends BaseAction {
    FindItemByName(int key, String info) {
        super(key, info);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по имени --------------");
        System.out.println("------------------ Результат --------------------");
        String key = input.ask("Введите имя заявки, для ее поиска :");
        Item[] items = tracker.findByName(key);
        if (items != null) {
            for (Item item : items) {
                System.out.println(item); }
            System.out.println("-------------------------------------------------");
        }
    }
}
