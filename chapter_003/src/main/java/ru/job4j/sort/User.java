package ru.job4j.sort;
import java.util.Objects;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 2.0
 * @since 06.09.2019
 */
public class User implements Comparable<User> {
    private String name;
    private int age;
    User(String name, int age) {
        this.name = name;
        this.age = age;

    }
    int getAge() {
        return age;
    }
    /**
     * Переопределенный метод интерфейса Comparable для выполнения базовой сортировки
     * @param o - передаваемый объект
     * @return - результат ставнения возрастов
     */
    @Override
    public int compareTo(User o) {
        return this.age - o.getAge();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age
                &&
                Objects.equals(name, user.name);
    }
    @Override
    public String toString() {
        return "User{"
                +
                "name='"
                +
                name + '\''
                +
                ", age="
                +
                age
                +
                '}';
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    String getName() {
        return name;
    }
}