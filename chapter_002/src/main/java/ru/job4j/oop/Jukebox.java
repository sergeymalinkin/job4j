package ru.job4j.oop;
/**
 * Музыкальный автомат
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 17.09.2019
 */
class Jukebox {

    private void music(int position) {

        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        }
        else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main (String[]args){
        Jukebox songmaster = new Jukebox();
        songmaster.music(1);
        songmaster.music(2);
    }
}

