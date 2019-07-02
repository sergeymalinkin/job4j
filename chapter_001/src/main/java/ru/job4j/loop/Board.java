package ru.job4j.loop;

public class Board {
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();

        int ii = width, jj = height;

        for (ii=0;ii<height;ii++) {
            for (jj=0;jj<width;jj++) {

                if (ii % 2 == 0 && jj % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }

            }

            screen.append(ln);
        }
        return screen.toString();
    }
}