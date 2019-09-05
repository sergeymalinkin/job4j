package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 3.0
 * @since 05.09.2019.
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();
    /**
     * Случайное значение для генерации id .
     */
    private static final Random RN = new Random();
    /**
     * Метод, реализующий добавление заявки в хранилище
     * @param item новая завка
     */
    Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * @return уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
    /**
     * Метод реализующий редактирование заявки в хранилище
     * @return id.
     */
    boolean replace(String id, Item item) {
        boolean result = false;
        System.out.println(id);
        int index = 0;
        for (Item it : items) {
            if (it != null && it.getId().equals(id)) {
                item.setId(id);
                items.set(index, item);
                result = true;
                break;
            }
            index++;
        }
        return result;
    }
    /**
     * Метод, реализующий удаление заявки из хранилища
     * @param id уникальный ключ заяки.
     */
    boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index != items.size(); index++) {
            if (this.items.get(index).getId().equals(id)) {
                this.items.remove(index);
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Метод, реализущий получение списка всех заявок из хранилища.
     * @return all items.
     */
    ArrayList<Item> findAll() {
        return new ArrayList<>(items);
    }
    /**
     * Метод, реализущий получение списка по имени из хранилища.
     *  @param key - уникальный ключ заявки.
     */
    ArrayList<Item> findByName(String key) {
        ArrayList<Item> find = new ArrayList<>();
        for (Item i : items) {
            if (i.getName().equals(key)) {
                find.add(i);
            }
        }
        return find;
    }
        /**
         * Метод реализующий поиск заявки в хранилище по id
         * @param id ключ заявки.
         * @return result.
         */
        Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}