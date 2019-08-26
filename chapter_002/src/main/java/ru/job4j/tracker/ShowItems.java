package ru.job4j.tracker;

public class ShowItems extends BaseAction {
    ShowItems(int key, String info) {
        super(key, info);
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

