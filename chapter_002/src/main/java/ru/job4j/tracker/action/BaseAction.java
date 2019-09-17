package ru.job4j.tracker.action;
/**
 * Базовый класс для действий
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 09.09.2019
 */
public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }
    @Override
    public int key() {
        return this.key;
    }
    @Override
    public String info() {
        return String.format("%s : %s", this.key, this.name);
    }
}

