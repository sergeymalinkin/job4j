package ru.job4j.oop;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 18.09.2019
 */
public class Jar {
    /**
     * Этот метод переливает воду из одного сосуда в другой.
     */
    private int value;

    private Jar(int size) {
        this.value = size;
    }

    private void pour(Jar another) {
        this.value = this.value + another.value;
        another.value = 0;
    }

    public static void main(String[] args) {
        Jar first = new Jar(10);
        Jar second = new Jar(5);
        System.out.println("first : " + first.value + ". second : " + second.value);
        first.pour(second);
        System.out.println("first : " + first.value + ". second : " + second.value);

    }
}
