package ru.job4j.sort;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 2.0
 * @since 06.09.2019
 */
public class SortUserTest {
    private final SortUser sortUser = new SortUser();
    @Test
    public void testSort() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("Sergey", 44));
        list.add(new User("Mike", 68));
        list.add(new User("Andrey", 21));
        Set<User> result = sortUser.sort(list);
        Set<User> expected = new TreeSet<>();
        expected.add(new User("Andrey", 21));
        expected.add(new User("Sergey", 44));
        expected.add(new User("Mike", 68));
        assertThat(result, is(expected));
    }
    /**
     * Тест сортировки по длине имени
     */
    @Test
    public void whenUsersThenSortNames() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("Дмитрий", 25));
        list.add(new User("Андрей", 30));
        list.add(new User("Анастасия", 20));
        list.add(new User("София", 25));
        List<User> result = sortUser.sortNameLength(list);
        List<User> expected = new ArrayList<>();
        expected.add(new User("София", 25));
        expected.add(new User("Андрей", 30));
        expected.add(new User("Дмитрий", 25));
        expected.add(new User("Анастасия", 20));
        assertThat(result, is(expected));
        //System.out.println(result);
    }
    /**
     * Тест сортировки по всем полям.
     */
    @Test
    public void whenUsersThenSortBothFields() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("Андрей", 25));
        list.add(new User("Алекс", 30));
        list.add(new User("Андрей", 20));
        list.add(new User("Алекс", 25));
        List<User> result = sortUser.sortByAllFields(list);
        List<User> expected = new ArrayList<>();
        expected.add(new User("Алекс", 25));
        expected.add(new User("Алекс", 30));
        expected.add(new User("Андрей", 20));
        expected.add(new User("Андрей", 25));
        assertThat(result, is(expected));
    }
}