package ru.job.search;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 02.09.2019
 */
class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }
    String getName() {
        return name;
    }
    String getSurname() {
        return surname;
    }
    String getPhone() {
        return phone;
    }
    String getAddress() {
        return address;
    }
}
