package ru.job4j.chess.firuges;

import ru.job4j.chess.firuges.exceptions.ImpossibleMoveException;
/**
 *  Интерфейс для фигур.
 *
 *  @author Sergey Malinkin (sloyz@ya.ru).
 *  @since 28.08.2019.
 *  @version 1.0
 */
public interface Figure {
    Cell position();
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;
    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );
    }
    Figure copy(Cell dest);
}
