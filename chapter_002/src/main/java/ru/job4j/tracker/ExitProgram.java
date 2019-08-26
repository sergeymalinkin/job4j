package ru.job4j.tracker;

public class ExitProgram extends BaseAction {
    private final StartUI ui;
    ExitProgram(int key, String info, StartUI ask) {
        super(key, info);
        this.ui = ask;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
//        System.out.println("Выбран пункт меню 6. Выход из программы. До свидания!");
        this.ui.stop();
    }

}