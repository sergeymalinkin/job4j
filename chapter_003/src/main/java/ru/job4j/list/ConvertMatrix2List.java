package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 03.09.2019
 */
public class ConvertMatrix2List {
    /**
     * Метод конвертирует двумерный массив в ArrayList.
     * public List<Integer> toList (int[][] array) {} -
     * в метод приходит двумерный массив целых чисел,
     * необходимо пройтись по всем элементам массива
     * и добавить их в List<Integer>.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }
}