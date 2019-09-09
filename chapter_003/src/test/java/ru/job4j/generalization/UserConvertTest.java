package ru.job4j.generalization;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 04.09.2019
 */
public class UserConvertTest {
    /**
     * Тест для проверки класса UserConvert..
     * Создаем коллекцию, в нее добавляем трех пользователей.
     * Проверяем результат.
     */
    @Test
    public void whenListThenMap() {
        UserConvert converter = new UserConvert();
        List<User> users = List.of(
        new User(1, "Sergey", "Moscow"),
        new User(2, "Andrey", "Ukhta"),
        new User(3, "Mike", "Lappenkulta")
        );

        Map<Integer, User> result = UserConvert.process(users);
        assertThat(result.get(2).getName(), is("Andrey"));
    }
}
