package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 3.0
 * @since 05.09.2019.
 */
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
    public void whenInvalidThenCorrectInput() {
        List<String> list = new ArrayList<>();
        list.add("q");
        list.add("1");
        List<Integer> listInt = new ArrayList<>();
        listInt.add(1);
        ValidateInput input = new ValidateInput(new StubInput(list));
        input.ask("Ввод", listInt);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Пожалуйста, введите корректное значение.%n")
                )
        );
    }
    @Test
    public void whenInvalidInput() {
        List<String> list = new ArrayList<>();
        list.add("-1");
        list.add("1");
        List<Integer> listInt = new ArrayList<>();
        listInt.add(1);
        ValidateInput input = new ValidateInput(new StubInput(list));
        input.ask("Ввод", listInt);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Пожалуйста, выберите пункт меню.%n")
                )
        );
    }
}