package ru.job4j.oop;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @since 20.09.2019
 */
public class Bus implements Transport {
    private Bus bus = new Bus();

    @Override
    public void go() {
    bus.go();
    }

    @Override
    public void pass(int pass) {
        bus.pass(5);
    }

    @Override
    public int fuel(int gas, int cost) {
        bus.fuel(15, 55);
        return cost;
    }
}
