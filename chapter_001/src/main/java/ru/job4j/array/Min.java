package ru.job4j.array;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 13.09.2019
 */
class Min {
    /**
     * Метод, определяющий минимальное число в массиве.
     * @param array массив
     * @return минимальное значение
     */
    static int findMin(int[] array) {
        var min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}
