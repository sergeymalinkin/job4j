package ru.job4j.tracker;
/**
 * класс ValidateInput, наследует ConsoleInput. В нем переопределен метод ask таким образом,
 * что бы обрабатывались исключительные ситуации (при помощи блоков try { … } catch( … ) { … }).
 */
public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        /*
          Если ошибок нет, то возвращается номер нажатой клавищи.
          Если исключительная ситуация, то возвращается ошибка -1.
         */
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                //moe.printStackTrace();
                System.out.println("Введите пункт меню");
            } catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста, введите корректное значение");
            }
        } while (invalid);
        return value;
    }
}

