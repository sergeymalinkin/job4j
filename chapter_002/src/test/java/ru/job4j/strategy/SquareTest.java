package ru.job4j.strategy;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by Sergey Malinkin (sloyz@ya.ru) on 21.08.2019.
 */
public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("*******").append(System.lineSeparator())
                                .append("*     *").append(System.lineSeparator())
                                .append("*     *").append(System.lineSeparator())
                                .append("*******").append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
