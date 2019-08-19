package ru.job4j.tracker;
/**
 * @version 1.0
 * @since 17.08.2019
 */
public class StartUI {
//    private ConsoleInput input = new ConsoleInput();
//    private Tracker tracker = new Tracker();
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для отображения всех заявок.
     */
    private static final String SHOW = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String REPLACE = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска заявки по id.
     */
    private static final String FIND_BY_ID = "4";
    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final String FIND_BY_NAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
//    /**
//     * Получение данных от пользователя.
//     */
    private final ConsoleInput input;
//    /**
//     * Хранилище заявок.
//     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(ConsoleInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню:");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItems();
            } else if (REPLACE.equals(answer)) {
                this.replaceItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findByIdItem();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findByNameItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    /**
     * Метод реализует добавленяи новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId: " + item.getId() + " " + "добавлена!-----------");
    }
    /**
     * Метод реализует отображение всех заявок в хранилище.
     */
    private void showAllItems() {
        Item[] items = this.tracker.findAll();
        System.out.println("------------ Отобразить все заявки --------------");
        for (Item item : items) {
            System.out.println("ID заявки:     |" + item.getId());
            System.out.println("Имя заявки:    |" + item.getName());
            System.out.println("Описание:      |" + item.getDesc());
            System.out.println("-------------------------------------------------------");
        }
    }
    private void replaceItem() {
        System.out.println("------------ Заменить заявку --------------");
        String id = this.input.ask("Введите id заявки :");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) {
            System.out.println("------------ Заявка с Id: " + item.getId() + " " + "изменена!-----------");
        } else {
            System.out.println("Заявка не найдена");
        }
    }
    private void deleteItem() {
        System.out.println("------------ Удалить заявку --------------");
        String id = this.input.ask("Введите id заявки :");
        if (this.tracker.delete(id)) {
            System.out.println("------------ Заявка с Id: " + id + " " + "удалена!-----------");
        } else {
            System.out.println("Заявка не найдена");
        }
    }
        private void findByIdItem() {
            System.out.println("------------ Поиск заявки по ID --------------");
            String id = this.input.ask("Введите id заявки :");
            System.out.println("----------------- Результат ------------------");
            Item item = this.tracker.findById(id);
            if (item != null) {
                System.out.println(item.toString());
            } else {
                System.out.println("Item not found");
            }
            System.out.println("----------------------------------------------");
        }
        private void findByNameItem() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки :");
        System.out.println("------------------ Результат --------------------");
        for (Item item : this.tracker.findByName(name)) {
            System.out.println(item.toString());
            System.out.println("---------------------------------------------");
        }
    }
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавление новой заявки");
        System.out.println("1. Отобразить все заявки");
        System.out.println("2. Замена заявки");
        System.out.println("3. Удаление заявки");
        System.out.println("4. Поиск заявки по ID");
        System.out.println("5. Поиск заявки по имени");
        System.out.println("6. Выход");
    }
        public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
