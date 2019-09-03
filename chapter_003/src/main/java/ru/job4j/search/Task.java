package ru.job4j.search;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0$
 * @since 02.09.2019$
 */
public class Task {
    private String desc;
    private int priority;

    Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}

