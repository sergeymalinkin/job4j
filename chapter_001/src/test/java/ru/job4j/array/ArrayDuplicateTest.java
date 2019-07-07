package ru.job4j.array;

import org.hamcrest.collection.IsArrayContainingInAnyOrder;
import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {

        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expect = {"Привет", "Мир", "Супер"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] resultArray = duplicate.remove(input);
        assertThat(resultArray, is(expect));
    }
    @Test
    public void whenRemoveAllDuplicatesThenArrayWithoutDuplicate() {

        String[] input = {"Привет", "Привет", "Мир", "Мир", "Супер", "Супер"};
        String[] expect = {"Мир", "Привет", "Супер"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] resultArray = duplicate.remove(input);
        assertThat(resultArray, arrayContainingInAnyOrder(expect));
    }
}
