package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.Tracker;
/**
 * Действие - выход из программы.
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 2.0.
 * @since 17.09.2019.
 */
public class ExitProgram extends BaseAction {
    private final StartUI ui;
    public ExitProgram(int key, String info, StartUI ui) {
        super(key, info);
        this.ui = ui;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        this.ui.stop();
    }
}