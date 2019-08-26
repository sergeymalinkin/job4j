package ru.job4j.tracker;

public class ExitProgram extends BaseAction {
    ExitProgram(int key, String info) {
        super(key, info);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
    }
}