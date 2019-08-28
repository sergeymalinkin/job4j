package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
/**
 *
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
    public Cell[] way(Cell source, Cell dest) {
        return new Cell[] {
                dest
        };
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}