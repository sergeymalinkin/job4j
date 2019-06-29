package ru.job4j.condition;

/**
 * Метод max должен возвращать максимальное число из first и second.
 * @author Sergey Malinkin(sloyz@ya.ru).
 * @version 1.0.
 * @since 27.06.2019
 */

public class Max {
    public int max(int left, int right) {
        return left > right ? left : right;
    }
}