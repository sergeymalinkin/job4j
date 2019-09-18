package ru.job4j.oop.redhood;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 18.09.2019
 */
public class Story {
    public static void main(String[] args) {
        Pioneer petya = new Pioneer();
        Girl girl = new Girl();
        Wolf wolf = new Wolf();

        girl.help(petya);
        wolf.eat(girl);
        petya.kill(wolf);
    }
}
