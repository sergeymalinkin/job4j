package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.exceptions.ImpossibleMoveException;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 28/08/2019
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }
    @Override
    public Cell position() {
        return this.position;
    }
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (Math.abs(dest.x - source.x) != Math.abs(dest.y - source.y)) {
            throw new ImpossibleMoveException("Слон ходит только по диагонали");
        }
        Cell[] move = new Cell[Math.abs(source.x - dest.x)];
        int deltaX = Integer.compare(source.x, dest.x);
        int deltaY = Integer.compare(source.y, dest.y);
        for (int i = 0; i < move.length; i++) {
            move[i] = Cell.values()[(8 * (source.x - deltaX)) + (source.y - deltaY)];
            deltaX = deltaX < 0 ? deltaX - 1 : deltaX + 1;
            deltaY = deltaY < 0 ? deltaY - 1 : deltaY + 1;
        }
        return move;
    }
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}