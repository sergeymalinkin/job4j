package ru.job4j.tracker;
/**
 * @version 2.0
 * @since 24.08.2019
 */
public class StartUI {
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        this.init();
    }

    private void init() {
        boolean exit = false;
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        while (!exit) {
            menu.show();
            String answer = this.input.ask("Введите пункт меню : ");
            menu.select(Integer.parseInt(answer));
            if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker());
    }
}
