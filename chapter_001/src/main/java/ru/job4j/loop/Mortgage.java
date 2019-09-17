package ru.job4j.loop;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @since 16.09.2019
 */
class Mortgage {
    /**
     * Метод считает количество лет необходимых для погашения кредита.
     * @param amount - сумма кредита.
     * @param salary - годовой доход.
     * @param percent - проценты по кредиту.
     * @return - количество лет к погашению.
     */
    int year(int amount, int salary, double percent) {
        int year = 0;
        double balance = 0;
        double postBalance;
        postBalance = amount + amount * (percent / 100);
        while (balance >= 0) {
            balance = postBalance - salary;
            postBalance = balance + balance * (percent / 100);
            year++;
        }
        return year;
    }
}