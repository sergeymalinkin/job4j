package ru.job4j.list;
import java.util.List;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 03.09.2019
 */
class ConvertList2Array {
    /**
     * Метод конвертирует ArrayList в двумерный массив.
     *
     */
    int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / (double) rows);
        int[][] array = new int[rows][cells];
        int row = 0;
        int cell = 0;
        for (Integer l : list) {
            array[row][cell++] = l;
            if (cell >= cells) {
                cell = 0;
                row++;
            }

        }
        return array;
    }
}