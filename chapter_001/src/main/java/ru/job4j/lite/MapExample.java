package ru.job4j.lite;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 02.09.2019
 */
public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<>();
        students.put("sergey malinkin", 3);
        students.put("ivan ivanov", 5);

        System.out.println(students.get("sergey malinkin"));
        for (String student : students.keySet()) {
            System.out.println(String.format("%s : %s", student, students.get(student)));
        }
        for (Integer scope : students.values()) {
            System.out.println(String.format("%s", scope));
        }

    }
}
