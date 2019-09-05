package ru.job4j.tracker;
import java.util.List;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 3.0
 * @since 05.09.2019.
 */
public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. Если пользователь
     * хочет выбрать добавление новой заявки ему нужно ввести:
     * 0 - выбор пункта меню "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * y - выйти из трекера.
     */
    private List<String> answers;
    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;

    StubInput(List<String> answers) {
        this.answers = answers;
    }
    /**
     * Давайте рассмотрим, как работает этот метод.
     * у нас есть объект в котором содержатся заранее продуманные ответы.
     * При последовательном вызове метода ask нам надо возвращать соответствующие данные.
     * Как если бы мы симулировали поведение пользователя.
     * Для этого при каждом вызове метода ask мы увеличиваем счетчик и
     * при следующем вызове он вернет нам новое значение.
     */
    @Override
    public String ask(String question) {
        return this.answers.get(position++);
    }

    @Override
    public int ask(String question, List<Integer> range) {
        boolean exist = false;
        int key = Integer.parseInt(this.answers.get(position++));
        for (int number : range) {
            if (number == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range.");
        }
        return key;
    }
}