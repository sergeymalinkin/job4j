package ru.job4j.pojo;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 18.08.2019
 */
public class Book {
    private String name;
    private int count;

    Book(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
