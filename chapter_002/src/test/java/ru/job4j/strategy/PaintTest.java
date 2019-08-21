package ru.job4j.strategy;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by Sergey Malinkin (sloyz@ya.ru) on 21.08.2019.
 */
public class PaintTest  {
    @Test
    public void whenDrawSquare() {
        // получаем ссылку на стандартный вывод в консоль.
        PrintStream stdout = System.out;
        // Создаем буфер для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
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
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }
}