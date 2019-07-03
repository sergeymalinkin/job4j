package ru.job4j.loop;

public class Fitness {
    public int calc(int ivan, int nik) {
        int month = 0;

//        int i_pull = ivan*3;
//        int n_pull = nik*2;
//        int i = 3;
//        int n = 2;

//        while (i_pull < n_pull) {
//        while ((ivan*i<nik*2)){

        while (ivan>nik){
           ivan*=3;
           nik*=2;
           month++;


        }
        return month;
    }
}