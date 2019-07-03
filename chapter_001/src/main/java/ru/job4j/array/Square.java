package ru.job4j.array;

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i<rst.length; i++) {
            rst[i] = i+1;
            rst[i] = rst[i]*rst[i];
        }
        return rst;
    }
}