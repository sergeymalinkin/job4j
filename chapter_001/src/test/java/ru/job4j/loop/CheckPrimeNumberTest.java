package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 15.09.2019
 */
public class CheckPrimeNumberTest {
    @Test
    public void when5() {
        CheckPrimeNumber prime = new CheckPrimeNumber();
        boolean rsl = prime.check(5);
        assertThat(rsl, is(true));
    }

    @Test
    public void when4() {
        CheckPrimeNumber prime = new CheckPrimeNumber();
        boolean rsl = prime.check(4);
        assertThat(rsl, is(false));
    }
}