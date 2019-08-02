package ru.job4j.condition;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenMax2To1Then1() {
        Max max = new Max();
        int result = max.max(2, 1);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax1To2Then1() {
        Max max = new Max();
        int result = max.max(2, 2);
        assertThat(result, is(2));
    }
    public void whenThirdMaxOfTheFour() {
        Max check = new Max();
        int result = check.max(1, 2, 4, 3);
        assertThat(result, Matchers.is(4));
    }
    @Test
    public void whenFirstMaxOfTheFour() {
        Max check = new Max();
        int result = check.max(4, 3, 2, 3);
        assertThat(result, Matchers.is(4));
    }
    @Test
    public void whenFourthMaxOfTheFour() {
        Max check = new Max();
        int result = check.max(1, 3, 2, 4);
        assertThat(result, Matchers.is(4));
    }
    @Test
    public void whenThirdMaxOfTheThree() {
        Max check = new Max();
        int result = check.max(1, 2, 3);
        assertThat(result, Matchers.is(3));
    }
    @Test
    public void whenSecondMaxOfTheThree() {
        Max check = new Max();
        int result = check.max(1, 3, 2);
        assertThat(result, Matchers.is(3));
    }
    @Test
    public void whenFirstMaxOfTheThree() {
        Max check = new Max();
        int result = check.max(3, 1, 2);
        assertThat(result, Matchers.is(3));
    }
}