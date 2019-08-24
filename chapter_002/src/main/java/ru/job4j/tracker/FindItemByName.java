package ru.job4j.tracker;

//import org.jetbrains.annotations.Contract;

public class FindItemByName implements UserAction {
    private int key;
    private String info;

//    @Contract(pure = true)
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
//        String name = input.ask("Пожалуйста, введите имя заявки:");
//        String desc = input.ask("Пожалуйста, введите описание заявки:");
//        Item item = new Item(name, desc);
//        tracker.add(item);
//        System.out.println("------------ Заявка с Id: : " + item.getId());
//        System.out.println("------------ Заявка с именем : " + item.getName());
//        System.out.println("------------ Заявка с описанием : " + item.getDesc() + " " +"найдена!");
        String key = input.ask("Введите имя заявки, для ее поиска :");
        Item[] items = tracker.findByName(key);
        if (items != null) {
            for (Item item : tracker.findByName(key)) {
                System.out.println(item); }
            System.out.println("-------------------------------------------------");

        }
    }
}
