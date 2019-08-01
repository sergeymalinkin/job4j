    package ru.job4j.condition;

/**
 * Перегруженный метод max должен возвращать максимальное число для трех и четырех чисел.
 * @author Sergey Malinkin(sloyz@ya.ru).
 * @version 1.0.
 * @since 01.08.2019
 */

public class Max {
    public int max(int first, int second) {
        return first > second? first : second;
    }

    public int max(int first, int second, int third, int fourth) {
        int tmp = max(second, third);
        return max(first,second)< tmp ? third : fourth;
    }
}

