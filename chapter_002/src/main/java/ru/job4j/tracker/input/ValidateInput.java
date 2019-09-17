package ru.job4j.tracker.input;
import java.util.List;

import static java.lang.String.format;
/**
 * Проверка введенных данных на ошибки.
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 3.0
 * @since 05.09.2019.
 */
public class ValidateInput implements Input {
    /**
     * класс ValidateInput, наследует ConsoleInput. В нем переопределен метод ask таким образом,
     * что бы обрабатывались исключительные ситуации (при помощи блоков try { … } catch( … ) { … }).
     */
    private final Input input;
    public ValidateInput(final Input input) {
        this.input = input;
    }
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }
    @Override
    public int ask(String question, List<Integer> range) {
        /*
         Если ошибок нет, то возвращается номер нажатой клавищи.
         Если исключительная ситуация, то возвращается ошибка -1.
         */
        boolean invalid = true;
        int answer = -1;
        do {
            try {
                answer = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException e) {
                System.out.print(format("Пожалуйста, выберите пункт меню.%n"));
            } catch (NumberFormatException e) {
                System.out.print(format("Пожалуйста, введите корректное значение.%n"));
            }
        } while (invalid);
        return answer;
    }
}