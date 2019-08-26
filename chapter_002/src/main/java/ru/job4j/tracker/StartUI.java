package ru.job4j.tracker;
/**
 * @version 3.0
 * @since 26.08.2019
 */
public class StartUI {
    /**
     * Константа для выхода из цикла.
     */
    private static final int EXIT = Integer.parseInt("6");
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
        int[] range = new int[menu.getActionsLength()];
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range[i] = i;
        }
        while (!exit) {
            menu.show();
            int answer = input.ask("Введите пункт меню : ", range);
            menu.select(answer);
            if (EXIT == answer) {
                exit = true;
            }
        }
    }
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }
}


