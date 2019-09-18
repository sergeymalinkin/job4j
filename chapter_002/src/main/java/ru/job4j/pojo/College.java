package ru.job4j.pojo;

import java.util.Date;
/**
 * Модель данных
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 19.09.2019
 */
public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Сергей Малинкин");
        student.setGroup(215);
        student.setReceipt(new Date());
        System.out.println(student.getName() + " поступил в группу - " + student.getGroup() + " : " + student.getReceipt());
    }
}
