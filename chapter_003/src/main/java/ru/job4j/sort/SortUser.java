package ru.job4j.sort;

import java.util.*;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 2.0
 * @since 06.09.2019
 */
class SortUser {
    /**
     * Метод сортирующий коллекцию с помощью встроенного функционала TreeSet.
     * @param list - передаваемая коллекция
     * @return - отсортированная коллекиция типа Set
     */
    Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }
    /**
     * Метод для сортировки по длинне имени пользователя
     * @param list - коллекиця
     * @return - отсортированная коллекция типа List
     */
    List<User> sortNameLength(List<User> list) {
        list.sort(Comparator.comparingInt(o -> o.getName().length()));
        return list;
    }
    /**
     *
     * Метод, сортирующий пользователей сначала по имени в лексикографическом порядке, потом по возрасту.
     * @param list - коллекиця
     * @return - отсортированная коллекция типа List
     */
     List<User> sortByAllFields(List<User> list) {
        Comparator<User> comparator = Comparator.comparing(User::getName).thenComparing(User::getAge);
        list.sort(comparator);
        return list;
    }
}