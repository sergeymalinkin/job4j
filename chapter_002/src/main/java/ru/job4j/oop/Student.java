package ru.job4j.oop;
/**
 *
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 17.09.2019
 */
public class Student {
    private void song() {
        System.out.println("I believe I can fly");
    }
    private void music() {
        System.out.println("Tra tra tra");
    }
    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.song();
        petya.song();
        petya.song();
    }
}
