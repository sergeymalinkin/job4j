package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        //напишите здесь тест, проверяющий, что факториал для числа 5 равен 120.
        Factorial factorial = new Factorial();
        int sum = factorial.calc(5);
        int expected = 120;
        assertThat(sum, is(expected));
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        //напишите здесь тест, проверяющий, что факториал для числа 0 равен 1.
        Factorial factorial = new Factorial();
        int sum = factorial.calc(0);
        int expected = 1;
        assertThat(sum, is(expected));
    }
}