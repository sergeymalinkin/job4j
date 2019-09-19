package ru.job4j.oop;

import java.util.Random;
import java.util.Scanner;

/**
 * Чтение из консоли. Класс Scanner.
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 19.09.2019
 */
public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String name = input.nextLine();
        int answer = new Random().nextInt(3);
        if (answer == 0) {
            System.out.println("О, да!");
        } else if (answer == 1) {
            System.out.println("O, нет!");
        } else {
            System.out.println("Приходите в пятницу, позавчера!");
        }
    }
}

