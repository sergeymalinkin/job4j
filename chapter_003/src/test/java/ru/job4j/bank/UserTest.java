package ru.job4j.bank;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 08.09.2019
 */
public class UserTest {
    @Test
    public void whenTwoEqualsThenTrue() {
        User first = new User("Sergey", "7814");
        User second = new User("Sergey", "7814");
        assertThat(first.equals(second), is(true));
    }

    @Test
    public void whenTwoEqualsNameButNotPassportThenFalse() {
        User first = new User("Sergey", "7814");
        User second = new User("Sergey", "7819");
        assertThat(first.equals(second), is(false));
    }

    @Test
    public void whenOneOfTwoNullThenFalse() {
        User first = new User(null, "7814");
        User second = new User("Sergey", "7814");
        assertThat(first.equals(second), is(false));
    }
}