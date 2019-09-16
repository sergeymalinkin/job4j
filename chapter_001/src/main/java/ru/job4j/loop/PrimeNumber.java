package ru.job4j.loop;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @since 15.09.2019.
 */
class PrimeNumber {
    /**
     * Метод должен  посчитать количество простых чисел от 1 до finish.
     * @param finish - конечное число.
     * @return - количество простых чисел.
     */
    int calc(int finish) {
        int count = 0;
        for (int i = 2; i <= finish; i++) {
            count++;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}
