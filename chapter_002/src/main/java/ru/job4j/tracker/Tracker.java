package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Трекер.
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
     * Случайное значение для генерации id.
     */
    private static final Random RN = new Random();
    /**
     * Метод, реализующий добавление заявки в хранилище.
     * @param item новая завка.
     */
    public Item add(Item item) {
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
     * Методб реализующий редактирование заявки в хранилище.
     *  @param id номер заявки.
     *  @param item отредактированная заявка.
     *  @return true - флаг успешного редактирования.
     */
    public boolean replace(String id, Item item) {
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
     * @return успешное удаление.
     */
    public boolean delete(String id) {
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
    public ArrayList<Item> findAll() {
        return new ArrayList<>(items);
    }
    /**
     * Метод, реализущий получение списка по имени из хранилища.
     *  @param key - уникальный ключ заявки.
     */
    public List<Item> findByName(String key) {
        return items.stream().filter(x->x.getName().equals(key)).collect(Collectors.toList());
    }
    /**
     * Метод реализующий поиск заявки в хранилище по id
     * @param id ключ заявки.
     * @return найденная заявка.
     */
    public Item findById(String id) {
        return items.stream().filter(x->x.getId().equals(id)).findFirst().orElse(null);
    }
}