package ru.job4j.oop;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 17.09.2019
 */
public class DummyDic {
    private String engToRus(String eng) {
        return "Неизвестное слово:  " + eng;
    }
    public static void main(String[] args) {
        DummyDic dic = new DummyDic();
        String say = dic.engToRus("two");
        System.out.println(say);
    }
}
