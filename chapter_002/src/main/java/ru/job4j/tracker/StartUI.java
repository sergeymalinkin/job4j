package ru.job4j.tracker;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;

import java.util.List;
import java.util.function.Consumer;
/**
 *  Консольный ввод
 *  @author Sergey Malinkin (sloyz@ya.ru)
 *  @version 4.0
 *  @since 17.09.2019
 *  */
public class StartUI {
    /**
     * Flag для продолжения или выхода из программы.
     */
    private boolean exit = true;
    /**
     * Меню программы.
     */
    private MenuTracker menu;
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Конструтор инициализирующий поля.
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.menu = new MenuTracker(this.input, tracker, output);
    }
    /**
     * Основой цикл программы.
     */
    void init() {
        menu.fillActions(this);
        List<Integer> keys = menu.range();
        do {
            menu.show();
            int ask = this.input.ask("ВВЕДИТЕ ПУНКТ МЕНЮ : ", keys);
            menu.select(ask);
        } while (this.exit);
    }
    /**
     * Выход из программы.
     */
    public void stop() {
        this.exit = false;
    }
    /**
     * Запуск программы.
     * @param args параметры запуска.
     */
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