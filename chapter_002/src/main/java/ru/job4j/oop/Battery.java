package ru.job4j.oop;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 19.09.2019
 */
public class Battery {
    /**
     * Этот метод должен списывать заряд из батареи у котороый
     * вызывали метод exchange и добавить к объекту another.
     */
    private int load;

    private Battery(int load) {
        this.load = load;
    }

    private void exchange(Battery another) {
        this.load = this.load + another.load;
        another.load = 0;
    }
    public static void main(String[] args) {
        Battery first = new Battery(10);
        Battery second = new Battery(5);
        System.out.println("first : " + first.load + ". second : " + second.load);
        first.exchange(second);
        System.out.println("first : " + first.load + ". second : " + second.load);
    }
}
