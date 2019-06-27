package ru.job4j.calculator;
/**
 * Элементарный калькулятор.
 * @author Sergey Malinkin (sloyz@ya.ru).
 * @since 26.06.2019.
 */

public class Calculator {

    /**
     * Сложение.
     * @return name - decription: add.
     */

    public double add(double first, double second) {
        return first + second;
    }

    /**
     * Вычитание.
     * @return name - decription: subtract.
     */

    public double subtract(double first, double second) {
        return first - second;
    }

    /**
     * Деление.
     * @return name - decription: div.
     */
    public double div(double first, double second) {
        return first / second;
    }

    /**
     * Умножение.
     * @return name - decription: multiple.
     */
    public double multiple(double first, double second) {
        return first * second;
    }

}