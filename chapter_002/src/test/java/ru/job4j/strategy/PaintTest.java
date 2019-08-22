package ru.job4j.strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by Sergey Malinkin (sloyz@ya.ru) on 21.08.2019.
 */
public class PaintTest  {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }
    @Test
    public void whenDrawSquare() {
        // выполняем действия пишущиее в консоль.
        new Paint().draw(new Square());
        // проверяем результат вычисления.
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("*******").append(System.lineSeparator())
                                .append("*     *").append(System.lineSeparator())
                                .append("*     *").append(System.lineSeparator())
                                .append("*******").append(System.lineSeparator())
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                this.out.toString(),
                is(
                        new StringJoiner(
                                System.lineSeparator(), "",
                                System.lineSeparator())
                                .add("      *    ")
                                .add("   *      * ")
                                .add(" *          *")
                                .add("**************")
                                .toString()
                )
        );
    }
}
