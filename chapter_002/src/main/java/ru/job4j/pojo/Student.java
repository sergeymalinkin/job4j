package ru.job4j.pojo;

import java.util.Date;
/**
 * Модель данных
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 19.09.2019
 */
public class Student {
    private String name;
    private int group;
    private Date receipt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int getGroup() {
        return group;
    }

    void setGroup(int group) {
        this.group = group;
    }

    Date getReceipt() {
        return receipt;
    }

    void setReceipt(Date receipt) {
        this.receipt = receipt;
    }
}
