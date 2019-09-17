package ru.job4j.array;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 17.09.2019
 */
class Matrix {
    /**
     * Метод реализует таблицу умножения Пифагора.
     * @param size - размер размер таблицы.
     * @return - результат.
     */
    int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}

