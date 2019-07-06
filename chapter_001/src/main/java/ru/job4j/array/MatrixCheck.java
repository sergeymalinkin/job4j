package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int index = data.length;

        for (int i = 0; i < index - 1; i++) {
            if (data[i][i] != data[i + 1][i + 1]) {
                result = false;
                break;
            }
            if (data[i][index - i - 1] != data[0][index - 1]) {
                result = false;
                break;
            }
        }
        return result;

    }
}
