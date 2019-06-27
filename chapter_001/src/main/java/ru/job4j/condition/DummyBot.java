package ru.job4j.condition;

/**
 * @author Sergey Malinkin(sloyz@ya.ru).
 * @version 1.0.
 * @since 27.06.2019
 */
public class DummyBot {
    /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Задайте другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            // заменить ... на правильный ответ rsl = "ответ по заданию".
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) { // заменить ... на проверку, известен ли боту этот вопрос и он знает как на него ответить.
            // заменить ... на правильный ответ rsl = "ответ по заданию".
            rsl = "До скорой встречи.";

        }
        return rsl;
    }
}