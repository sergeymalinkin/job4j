package ru.job4j.calculator;
/**
 * Элементарный калькулятор.
 * @author Sergey Malinkin (sloyz@ya.ru).
 * @since 26.06.2019.
 */
public class Calculator {
    /**
     * Сложение.
     * @param first - первое число.
     * @param second - второе число.
     * @return name - description: add.
     */
    public double add(double first, double second) {
        return first + second;
    }
    /**
     * Вычитание.
     * @param first - первое число.
     * @param second - второе число.
     * @return name - decription: subtract.
     */
    public double subtract(double first, double second) {
        return first - second;
    }
    /**
     * Деление.
     * @param first - первое число.
     * @param second - второе число.
     * @return name - description: div.
     */
    public double div(double first, double second) {
        return first / second;
    }
    /**
     * Умножение.
     * @param first - первое число.
     * @param second - второе число.
     * @return name - description: multiple.
     */
    public double multiple(double first, double second) {
        return first * second;
    }
}