package ru.job4j.oop;
/**
 * Котики-обормотики
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 2
 * @since 18.09.2019
 */
public class Cat {
    private String name;
    private String food;

    private void eat(String meat) {
        this.food = meat;
    }
    private void giveNick(String nick) {
        this.name = nick;
    }
    private void show() {
        System.out.println("There are cat's nick : " + this.name);
        System.out.println("There are cat's food : " + this.food);
    }
    public static void main(String[] args) {
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();

        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();
    }
}
