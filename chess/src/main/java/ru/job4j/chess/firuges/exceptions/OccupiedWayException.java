package ru.job4j.chess.firuges.exceptions;
/**
 *  Создает исключение - ячейка занята.
 *
 *  @author Sergey Malinkin (sloyz@ya.ru).
 *  @since 28.08.2019.
 *  @version 1.0
 */
public class OccupiedWayException extends RuntimeException {
    public OccupiedWayException(String msg) {
        super(msg);
    }
}