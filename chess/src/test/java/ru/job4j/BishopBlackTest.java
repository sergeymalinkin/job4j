package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.exceptions.FigureNotFoundException;
import ru.job4j.chess.firuges.exceptions.OccupiedWayException;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *  Тесты для фигуры Черный Слон.
 *
 *  @author Sergey Malinkin (sloyz@ya.ru).
 *  @since 29.08.2019.
 *  @version 1.0
 */
public class BishopBlackTest {
    private final Logic logic = new Logic();
    /**
     * Тест проверяет движение Слона вправо вверх.
     */
    @Test
    public void whenBishopBlackMoveRightUpThenTrue() {
        logic.add(new BishopBlack(Cell.F8));
        boolean result = logic.move(Cell.F8, Cell.D6);
        assertThat(result, is(true));
    }

    /**
     * Тест проверяет движение Слона влево вниз.
     */
    @Test
    public void whenBishopBlackMoveLeftDownThenTrue() {
        logic.add(new BishopBlack(Cell.D6));
        boolean result = logic.move(Cell.D6, Cell.F8);
        assertThat(result, is(true));
    }

    /**
     * Тест проверяет движение Слона.
     */
    @Test
    public void whenBishopBlackWayThenCellSteps() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell[] result = bishopBlack.way(Cell.F8, Cell.C5);
        Cell[] expect = {Cell.E7, Cell.D6, Cell.C5};
        assertThat(result, is(expect));
    }
    /**
     * Тест проверяет условие, когда ячейка занята.
     */
    @Test
    public void whenOccupiedWayExceptionBishopBlack() {
        try {
            logic.add(new BishopBlack(Cell.H3));
            logic.move(Cell.H3, Cell.F5);
        } catch (OccupiedWayException owe) {
            assertThat(owe.getMessage(), containsString("Ячейка занята"));
        }
    }
    /**
     * Тест проверяет условие, когда фигура не найдена.
     */
    @Test
    public void whenFigureNotFoundAtTheBoard() {
        try {
            logic.move(Cell.D3, Cell.E3);
        } catch (FigureNotFoundException msg) {
            assertThat(logic.findBy(Cell.D3), is(-1));
            assertThat(logic.findBy(Cell.E3), is(-1));
        }
    }
}