package ru.job4j.tracker.input;

import java.util.List;
import java.util.Scanner;
/**
 * Консольный ввод
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 09.09.2019
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
    /**
     * метод проверки введенного значения меню.
     * @param question - ответ пользователя.
     * @param range - диапазон допустимых занчений меню.
     * @return - возврат числового значения меню.
     */
    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.parseInt(this.ask(question));
        boolean exist = false;
        for (int answer : range) {
            if (answer == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Нет такого пункта меню");
        }
        return key;
    }
}