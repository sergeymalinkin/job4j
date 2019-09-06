package ru.job4j.sort;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 06.09.2019
 */
    public class StringsCompareTest {
        @Test
        public void whenStringsAreEqualThenZero() {
            ListCompare compare = new ListCompare();
            int rst = compare.compare(
                    "Ivanov",
                    "Ivanov"
            );
            assertThat(rst, is(0));
        }

        @Test
        public void whenLeftLessThanRightResultShouldBeNegative() {
            ListCompare compare = new ListCompare();
            int rst = compare.compare(
                    "Ivanov",
                    "Ivanova"
            );
            assertThat(rst, lessThan(0));
        }

        @Test
        public void whenLeftGreaterThanRightResultShouldBePositive() {
            ListCompare compare = new ListCompare();
            int rst = compare.compare(
                    "Petrov",
                    "Ivanova"
            );
            assertThat(rst, greaterThan(0));
        }

        @Test
        public void secondCharOfLeftGreaterThanRightShouldBePositive() {
            ListCompare compare = new ListCompare();
            int rst = compare.compare(
                    "Petrov",
                    "Patrov"
            );
            assertThat(rst, greaterThan(0));
        }

        @Test
        public void secondCharOfLeftLessThanRightShouldBeNegative() {
            ListCompare compare = new ListCompare();
            int rst = compare.compare(
                    "Patrova",
                    "Petrov"
            );
            assertThat(rst, lessThan(0));
        }
}
