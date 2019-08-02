    package ru.job4j.condition;

/**
 * Перегруженный метод max должен возвращать максимальное число для трех и четырех чисел.
 * @author Sergey Malinkin(sloyz@ya.ru).
 * @version 3.0.
 * @since 02.08.2019
 */

public class Max {
    public int max(int first, int second) {
        return first > second ? first : second;
    }
    public int max(int first, int second, int third) {
        int tmp = max(first, second);
        return max(third, tmp);
    }
    public int max(int first, int second, int third, int fourth) {
        int tmp = max(third, fourth);
        int tmp2 = max(first, second);
        return max(tmp, tmp2);
    }
}

