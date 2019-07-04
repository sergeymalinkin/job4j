package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        int n = array.length;
        for (int index = 0; index < n / 2; index++) {

            int temp = array[n - index - 1];
            array[n - index - 1] = array[index];
            array[index] = temp;
        }
        return array;
    }
}


////        for (int data = 0; data < array.length / 2; data++) {
////            index -> data.size; index - 1;
//            int tmp = array[data];
//            array[data] = array[array.length-data-1];
//            array[data] = tmp;

//        int temp = array[1];
//        array [1] = array [4];
//        array [4] = temp;

//        for (int data = array.length - 1; data >= 0; -- data) {
//                int tmp = array[data];
//                array[data] = array[array.length-data-1];
//                array[data] = tmp;
//        }
//        for (int index = 0; index < array.length % 2; index++) {
//            int tmp = array[index];
//            array[index] = array[array.length - 1 - index];
//            array[index] = tmp;


//            for (index = 0; index != n / 2; index--) {
//            temp = array[n - index - 1];
//            array[n - index - 1] = array[index];
//            array[index] = temp;
//            }





