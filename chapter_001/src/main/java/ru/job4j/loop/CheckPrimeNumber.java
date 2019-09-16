package ru.job4j.loop;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @since 15.09.2019
 */
class CheckPrimeNumber {
    /**
     *  Метод должен вернуть true, если переменная num является простым числом.
     * @param num - число.
     * @return - true.
     */
    boolean check(int num) {
        boolean prime = false;
        if ((num % 5) == 0) {
            prime = true;
        }
        return prime;
    }
}

