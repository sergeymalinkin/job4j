package ru.job4j.generalization;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
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
    List<User> list = new ArrayList<>();
    User user1 = new User(1, "Sergey");
    User user2 = new User(2, "Andrey");
    User user3 = new User(3, "Mike");

    list.add(user1);
    list.add(user2);
    list.add(user3);

    Map<Integer, User> result = new HashMap<>();
        result.put(user1.getId(), user1);
        result.put(user2.getId(), user2);
        result.put(user3.getId(), user3);
        HashMap<Integer, User> expect = UserConvert.process(list);
        assertThat(result, is(expect));
    }
}
