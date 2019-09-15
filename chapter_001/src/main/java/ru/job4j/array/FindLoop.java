package ru.job4j.array;

class FindLoop {
    static int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
    static int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1;
        for (int i = start + 1; i <= finish; i++) {
            if (data[i] == el) {
                rst = i;
            }
        }
        return rst;
    }
}