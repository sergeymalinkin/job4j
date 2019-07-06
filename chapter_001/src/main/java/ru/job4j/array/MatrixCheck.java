package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result;
        int index = data.length;
        int rightDiaonal = 0;
        int leftDiagonal = 0;
        for (int i = 0; i < index - 1; i++) {
            if (data[i][i] == data[i + 1][i + 1]) {
                leftDiagonal++;
            }
            if (data[index - 1][index - 1] == data[0][index - 1]) {
                rightDiaonal++;
            }
        }
        result = leftDiagonal == index - 1 || rightDiaonal == index - 1;
        return result;

    }
}


