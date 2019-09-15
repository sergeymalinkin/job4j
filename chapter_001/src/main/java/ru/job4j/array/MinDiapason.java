package ru.job4j.array;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 13.09.2019
 */
class MinDiapason {
    static int findMin(int[] array, int start, int finish) {
        var min = array[start];
        for (var i = start + 1; i <= finish; i++) {
            var value = array[i];
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}
