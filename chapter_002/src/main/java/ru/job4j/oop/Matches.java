package ru.job4j.oop;

import java.util.Scanner;

/**
 * Scanner и чтение числа из консоли. Игра спички.
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 19.09.2019
 */
public class Matches {
    public static void main(String[] args) {
        int matches = 11;
        Scanner input = new Scanner(System.in);
        System.out.println("Игра называется СПИЧКИ");
        System.out.println("Приглашаются два игрока.");
        boolean first = true;
        while (matches > 0) {
            System.out.print("Вы можете взять от 1 до 3 спичек. Вводите только цифры! Выбирайте: ");
            int i = input.nextInt();
            if (first) {
                System.out.println("Первый взял " + i + " спичек");
                first = false;
            } else {
                System.out.println("Второй взял " + i + " спичек");
                first = true;
            }
            matches -= i;
            System.out.println("Спичек осталось на столе " + matches);
        }
        String f = first ? "второй" : "первый";
        System.out.println("Победил " + f);
    }
}