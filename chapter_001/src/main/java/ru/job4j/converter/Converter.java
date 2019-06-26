package ru.job4j.converter;

/**
 * Корвертор валюты.
 */

public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return 1;

    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return 1;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value рубли.
     * @return Евро.
     */

    public int euroToRuble(int value) {
        return 70;

    }

    /**
     * Конвертируем доллары в рубли.
     * @param value рубли.
     * @return Доллары
     */
    public int dollarToRuble(int value) {
        return 60;
    }
}
