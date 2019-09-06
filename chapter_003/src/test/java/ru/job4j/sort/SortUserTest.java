package ru.job4j.sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
}