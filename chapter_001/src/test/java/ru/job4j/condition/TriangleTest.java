package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;


public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point first = new Point(0, 0);
        Point second = new Point(0, 2);
        Point third = new Point(2, 0);
        Triangle triangle = new Triangle(first, second, third);
        first.info();
        second.info();
        third.info();
        double result = triangle.area();
        double expected = 2D;
        System.out.println(String.format("Result is %s", result));
        assertThat(result, closeTo(expected, 0.1));
    }
}