package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.Tracker;

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