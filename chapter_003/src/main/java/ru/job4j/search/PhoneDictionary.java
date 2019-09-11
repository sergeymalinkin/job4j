package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 2.0
 * @since 10.09.2019
 */
class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    void add(Person person) {
        this.persons.add(person);
    }
    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    List<Person> find(String key) {
        List<Person> result = new ArrayList<>();

        for (var person : persons) {
            if ((key.contains(person.getName())
                    || key.contains(person.getSurname())
                    || key.contains(person.getPhone())
                    || key.contains(person.getAddress()))
            ) {
                result.add(person);
            }
        }
        return result;
    }
}

