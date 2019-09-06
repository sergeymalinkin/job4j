package ru.job4j.sort;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
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
}