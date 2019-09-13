package ru.job4j.tictactoe;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;
/**
 * Класс отвечает за проверку логики.
 */
class Logic3T {
    private final Figure3T[][] table;

    Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    private boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }
    /**
     * Метод определяет в поле выигрышные комбинации.
     * @param predicate проверяет наличие фигуры в клетке.
     * @return true, если есть выигрышная комбинация для О или Х.
     */
    private boolean isWinner(Predicate<Figure3T> predicate) {
        return this.fillBy(predicate, 0, 0, 1, 0)
                || this.fillBy(predicate, 0, 1, 1, 0)
                || this.fillBy(predicate, 0, 2, 1, 0)
                || this.fillBy(predicate, 0, 0, 0, 1)
                || this.fillBy(predicate, 1, 0, 0, 1)
                || this.fillBy(predicate, 2, 0, 0, 1)
                || this.fillBy(predicate, 0, 0, 1, 1)
                || this.fillBy(predicate, this.table.length - 1, 0, -1, 1);
    }
    boolean isWinnerX() {
        return this.isWinner(Figure3T :: hasMarkX);
    }
    boolean isWinnerO() {
        return this.isWinner(Figure3T :: hasMarkO);
    }
    /**
     * Метод пустые клетки для новых ходов.
     * @return false, если все поля заполнены.
     */
    boolean hasGap() {
        return !Stream.of(this.table)
                .flatMap(Arrays::stream)
                .allMatch(e -> e.hasMarkO() || e.hasMarkX());
    }
}