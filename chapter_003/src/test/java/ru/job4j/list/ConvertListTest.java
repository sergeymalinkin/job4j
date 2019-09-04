package ru.job4j.list;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 04.09.2019
 */
public class ConvertListTest {
    @Test
    public void when2ArrayThenListInteger() {
        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});

        List<Integer> result = convertList.convert(list);
        List<Integer> expect = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(result, is(expect));
    }
}
