package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int result = first > second ? first : second;
        return result > third ? result : third;


//        int result = first;
//        if (second > result) result = second;
//        if (third > result) result = third;
//
//        return result;

//        public class MultiMax {
//            public int max(int first, int second, int third) {
//        if (first > second) {
//            return first;
//        } else if (second > first) {
//            return second;
//        }

        //int result = first>second? first : second;
        //return result;

        //return third >> first > second ? first : second;
    }

}