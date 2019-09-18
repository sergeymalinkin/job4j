package ru.job4j.pojo;

import java.util.Date;
/**
 * Модель данных
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 19.09.2019
 */
public class Police {
    public static void main(String[] args) {
        License license = new License();
        license.setOwner("Petr Arsentev");
        license.setModel("Toyota");
        license.setCode("xx111x");
        license.setCreated(new Date());

        System.out.println(license.getOwner() + " has a car - " + license.getModel() + " : " + license.getCode());
    }
}