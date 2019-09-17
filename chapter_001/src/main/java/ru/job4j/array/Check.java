package ru.job4j.array;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 17.09.2019
 */
public class Check {
    /**
     * Метод должен проверить, что все элементы в массиве являются или true или false
     * @param data - массив
     * @return - возвращает true, если все значения true или false иначе возвращается false.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int index = 0; index < data.length - 1; index++) {
            if (data[index] != data[index + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}