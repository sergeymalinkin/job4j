package ru.job4j.tracker;
import java.util.List;
import java.util.function.Consumer;
/**
 * @version 3.0
 * @since 26.08.2019
 */
public class StartUI {
    private boolean exit = true;
    private final Consumer<String> output;
    private MenuTracker menu;
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
    StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
        this.menu = new MenuTracker(this.input, this.tracker, this.output);

    }
    void init() {
        menu.fillActions(this);
        List<Integer> keys = menu.range();
        do {
            menu.show();
            int ask = this.input.ask("Введите пункт меню : ", keys);
            menu.select(ask);
        } while (this.exit);
    }
    void stop() {
        this.exit = false;
    }
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker(),
                System.out::println)
                .init();
    }
}


