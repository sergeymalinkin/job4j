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
//    private String city;
    /**
     * Конструктор класса User.
     * @param id   уникальный номер.
     * @param name имя.
     */
    User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    /**
     * Геттеры класса User.
     */
    Integer getId() {
        return id;
    }

    String getName() {
        return name;
    }
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
                Objects.equals(name, user.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
