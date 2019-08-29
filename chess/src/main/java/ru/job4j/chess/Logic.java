package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.exceptions.FigureNotFoundException;
import ru.job4j.chess.firuges.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.exceptions.OccupiedWayException;
/**
 * Реализация логики движения фигур.
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 28.08.2019
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }
    /**
     * @param source - начальная позиция ячейки фигуры.
     * @param dest   - конечная ячейка фигуры.
     **/
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException,
            FigureNotFoundException {
        boolean rst = false;
        int index = this.findBy(source);
        int target = this.findBy(dest);
        if (index == -1) {
            throw new FigureNotFoundException("Фигура не найдена");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        for (int step = 0; step < steps.length; step++) {
            int empty = findBy(steps[step]);
            if (empty != -1 || target != -1) {
                throw new OccupiedWayException("Ячейка занята");
            }
        }
        if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
            rst = true;
            this.figures[index] = this.figures[index].copy(dest);
        }
        return rst;
    }
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }
    public int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}