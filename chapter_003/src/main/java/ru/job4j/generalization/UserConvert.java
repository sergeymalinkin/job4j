package ru.job4j.generalization;
import java.util.HashMap;
import java.util.List;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 04.09.2019
 */
class UserConvert {
    /**
     * Метод, который принимает в себя список пользователей и конвертирует его в Map
     * с ключом Integer id и соответствующим ему User.
     */
    static HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}

