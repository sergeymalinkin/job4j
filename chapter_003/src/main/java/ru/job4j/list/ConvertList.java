package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 04.09.2019
 */
class ConvertList {
    /**
     * Метод добавляет все элементы всех массивов в списке list в один общий лист Integer.
     */
    List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] ints: list) {
            for (int i: ints) {
                result.add(i);
            }
        }
        return result;
    }
    // нашел уж больно красивое решение, но это еще не проходили :)
    // реализация с помощью Stream API
    //     return list.stream().flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList());
}
