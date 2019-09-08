package ru.job4j.bank;
import java.util.Objects;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 06.09.2019
 */
public class Account {
    private double money;
    private final String requisites;

    Account(double money, String requisites) {
        this.money = money;
        this.requisites = requisites;
    }
    /**
     * Getter.
     * @return requisites - счет клиента.
     */
     String getRequisites() {
        return requisites;
    }
    /**
     * Getter.
     * @return money - деньги.
     */
    double getMoney() {
        return money;
    }
    /**
     * Метод зачисления денег на счет клиенту.
     * @param amount - сумма.
     */
    void addMoney(double amount) {
        this.money += amount;
    }
    /**
     * Метод списания денег со счета клиента.
     * @param amount - сумма.
     */
    void deductMoney(double amount) {
        this.money -= amount;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;

        return Double.compare(account.money, money) == 0
                && Objects.equals(requisites, account.requisites);
    }
    @Override
    public int hashCode() {
        return Objects.hash(money, requisites);
    }
    @Override
    public String toString() {
        return String.format("Account [Requisites: %s. Balance: %s.]", requisites, money);
    }
}