package ru.job4j.sort;
import java.util.Comparator;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 06.09.2019
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int length = Math.min(left.length(), right.length());
        for (int index = 0; index != length; index++) {
            result = Character.compare(left.charAt(index), right.charAt(index));
            if (!(result == 0)) {
                break;
            }
        }
        if (result == 0) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}
