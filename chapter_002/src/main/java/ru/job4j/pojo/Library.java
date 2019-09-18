package ru.job4j.pojo;

/**
 * Массивы и модели
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 19.09.2019
 */
public class Library {
    public static void main(String[] args) {
        Book java = new Book("Java the best of the best", 952);
        Book ruby = new Book("Ruby is cool", 888);
        Book pyton = new Book("Pyton very simple", 666);
        Book c = new Book("C++ so-so", 1358);

        Book[] books = new Book[4];
        books[0] = java;
        books[1] = ruby;
        books[2] = pyton;
        books[3] = c;

        for (Book b: books) {
            System.out.println(b.getName() + " - " + b.getCount());
        }
        System.out.println("Меняем С++ на Clean code");
        Book code = new Book("Clean code", 2500);
        books[3] = code;

        for (Book b: books) {
            System.out.println(b.getName() + " - " + b.getCount());
        }
        System.out.println("Меняем Ruby на Clean code");
        books[1] = code;
        for (Book b: books) {
            System.out.println(b.getName() + " - " + b.getCount());
        }

        System.out.println("Показать книги с именем code");
        for (Book b: books) {
            if ((b.getName().contains("code"))) {
                System.out.println(b.getName());
            }
        }
    }
}
