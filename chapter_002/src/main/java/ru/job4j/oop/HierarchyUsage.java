package ru.job4j.oop;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @since 20.09.2019
 */
public class HierarchyUsage {
    public static void main(String[] args) {
        // создаем объекта класса Car.
        Car car = new Car();
        // делаем приведение к типу родителя Machine.
        Machine machine = car;
        // делаем приведение к типу родителя Object.
        Car obj = car;
        // Приведение типа при создании объекта.
        Object ocar = new Object();
        // Приведение типа за счет повышение по иерархии.
        // Car carFromObject = (Car) ocar;

        // Ошибка в приведении типа.
        Object bicycle = new Object();
      //  Car cb = (Car) bicycle; // код завершится с ошибок приведения типов ClassCastException
    }
}
