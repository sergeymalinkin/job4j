package ru.job.search;

import java.util.ArrayList;
import java.util.List;

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
        return result;
    }
}

