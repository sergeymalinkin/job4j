package ru.job4j.tracker;
import java.util.List;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 3.0
 * @since 05.09.2019.
 */
public interface Input {
    String ask(String question);
    int ask(String question, List<Integer> range);
}
