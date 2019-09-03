package ru.job4j.list;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 03.09.2019
 */
public class ConvertList2ArrayTest {
    /**
     * Тест проверяет комбинацию преобразования 7 элементов списка в массив из 3-х строк
     */
    @Test
    public void when7ElementsThen9Rows3() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }
    /**
     * Тест проверяет комбинацию преобразования 7 элементов списка в массив из 4-х строк
     */
    @Test
    public void when7ElementsThen8Rows4() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 4);
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 0}
        };
        assertThat(result, is(expect));
    }
    /**
     * Тест проверяет комбинацию преобразования 7 элементов списка в массив из 5-х строк
     */
    @Test
    public void when7ElementsThen10Rows5() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 5);
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 0},
                {0, 0}
        };
        assertThat(result, is(expect));
    }
    /**
     * Тест проверяет комбинацию преобразования 7 элементов списка в массив из 6-х строк
     */
    @Test
    public void when7ElementsThen12Rows6() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 6);
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 0},
                {0, 0},
                {0, 0}
        };
        assertThat(result, is(expect));
    }
}