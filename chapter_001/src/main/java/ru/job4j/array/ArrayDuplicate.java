package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int duplicate = array.length;
        for (int out = 0; out < duplicate; out++) {
            for (int in = out + 1; in < duplicate; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[duplicate - 1];
                    duplicate --;
                    in--;
                    }
                }
            }
        return Arrays.copyOf (array, duplicate);
    }
}
