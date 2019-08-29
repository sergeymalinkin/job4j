package ru.job4j.chess.firuges.exceptions;
/**
 *  Создает исключение - ход фигуры невозможен.
 *
 *  @author Sergey Malinkin (sloyz@ya.ru).
 *  @since 28.08.2019.
 *  @version 1.0
 */
public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
