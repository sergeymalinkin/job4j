package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * @author Sergey Malinkin(sloyz@yandex.ru)
 * @version 1.0
 * @since 26.08.2019.
 * */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }
    @After
    public void loadSys() {
        System.setOut(this.out);
    }
    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.ask("Ввод", new int[] {1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Пожалуйста, введите корректное значение.%n")
                )
        );
    }
    @Test
    public void whenInvalidInputKey() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"-1", "1"})
        );
        input.ask("Ввод", new int[] {1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Пожалуйста, выберите пункт меню.%n")
                )
        );
    }
}

