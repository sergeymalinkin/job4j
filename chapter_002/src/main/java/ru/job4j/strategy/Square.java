package ru.job4j.strategy;
/**
 * Created by Sergey Malinkin (sloyz@ya.ru) on 21.08.2019.
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("*******").append(System.lineSeparator());
        pic.append("*     *").append(System.lineSeparator());
        pic.append("*     *").append(System.lineSeparator());
        pic.append("*******").append(System.lineSeparator());
        return pic.toString();
    }
}


