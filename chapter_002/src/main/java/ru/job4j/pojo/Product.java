package ru.job4j.pojo;

/**
 * Массивы и модели
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 19.09.2019
 */
public class Product {
    private String name;
    private int count;

    Product(String name, int count) {
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
