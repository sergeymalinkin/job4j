package ru.job4j.generalization;
import java.util.Objects;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 04.09.2019
 */
public class User {
    private Integer id;
    private String name;
    private String city;
    /**
     * Конструктор класса User.
     * @param id   уникальный номер.
     * @param name имя.
     */
    User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
    /**
     * Геттеры класса User.
     */
    Integer getId() {
        return id;
    }

    String getName() {
        return name; }
    String getCity() {
        return city; }
    /**
     * Переопределяем equals и hashCode, для корректного сравнения объектов.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id.equals(user.id)
                &&
                Objects.equals(name, user.name)
                &&
                Objects.equals(city, user.city);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, city);
    }
}
