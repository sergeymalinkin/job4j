package ru.job4j.loop;

public class Counter {
    public int add(int start, int finish) {
        int i, sum = 0;

        for (i = start; i <= finish; i++) {

            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
