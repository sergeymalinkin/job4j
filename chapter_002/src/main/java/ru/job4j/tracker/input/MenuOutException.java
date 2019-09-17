package ru.job4j.tracker.input;
/**
 * Выбранный пункт не содержится в текущем меню
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 09.09.2019
 */
class MenuOutException extends RuntimeException {
    MenuOutException(String msg) {
        super(msg);
    }
}
