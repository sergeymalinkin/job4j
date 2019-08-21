package ru.job4j.strategy;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by Sergey Malinkin (sloyz@ya.ru) on 21.08.2019.
 */
public class TriangleTest{
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("     *     ")
                                .append("  *      * ")
                                .append("*          *")
                                .append("*************")
                                .toString()
                )
        );
    }
}
