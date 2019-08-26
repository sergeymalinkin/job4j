package ru.job4j.tracker;
/**
 * класс ValidateInput, наследует ConsoleInput. В нем переопределен метод ask таким образом,
 * что бы обрабатывались исключительные ситуации (при помощи блоков try { … } catch( … ) { … }).
 */
public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }
    @Override
    public String ask(String question) {
       return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
                /*
          Если ошибок нет, то возвращается номер нажатой клавищи.
          Если исключительная ситуация, то возвращается ошибка -1.
         */
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Пожалуйста, выберите пункт меню.");
            } catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста, введите корректное значение.");
            }
        } while (invalid);
        return value;
    }
}

