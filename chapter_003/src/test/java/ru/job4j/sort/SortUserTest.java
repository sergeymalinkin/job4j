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
        List<User> users =  List.of(
                new User("Sergey", 44),
                new User("Mike", 68),
                new User("Andrey", 21)
        );

        Set<User> result = sortUser.sort(users);
        Set<User> expected  = Set.of(
                new User("Andrey", 21),
                new User("Sergey", 44),
                new User("Mike", 68)
        );
        assertThat(result, is(expected));
    }
    /**
     * Тест сортировки по длине имени
     */
    @Test
    public void whenUsersThenSortNames() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("Дмитрий", 25),
                new User("Андрей", 30),
                new User("Анастасия", 20),
                new User("София", 25)
        ));
        List<User> expected = List.of(
                new User("София", 25),
                new User("Андрей", 30),
                new User("Дмитрий", 25),
                new User("Анастасия", 20)
        );
        assertThat(sortUser.sortNameLength(users), is(expected));
    }
    /**
     * Тест сортировки по всем полям.
     */
    @Test
    public void whenUsersThenSortBothFields() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("Андрей", 25),
                new User("Алекс", 30),
                new User("Андрей", 20),
                new User("Алекс", 25)
        ));
        List<User> result = sortUser.sortByAllFields(users);
        List<User> expected =  List.of(
                new User("Алекс", 25),
                new User("Алекс", 30),
                new User("Андрей", 20),
                new User("Андрей", 25)
        );
        assertThat(result, is(expected));
    }
}