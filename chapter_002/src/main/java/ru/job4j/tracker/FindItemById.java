package ru.job4j.tracker;

public class FindItemById extends BaseAction {
    FindItemById(int key, String info) {
        super(key, info);
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
