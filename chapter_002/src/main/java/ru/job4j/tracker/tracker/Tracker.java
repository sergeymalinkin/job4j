package ru.job4j.tracker.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @version 2.0
 * @since 16.08.2019.
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    /**
     * Случайное значение для генерации id .
     */
    private static final Random RN = new Random();

    /**
     * Метод реализующий добавление заявки в хранилище
     *
     * @return id.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    String generateId() {
        //Реализовать метод генерации.
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
    /**
     * Метод реализующий редактирование заявки в хранилище
     *
     * @return id.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index < position; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                items[index] = item;
                items[index].setId(id);
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Метод должен удалить ячейку в массиве.
     * Для этого необходимо найти ячейку в массиве по id.  Далее сместить все значения
     * справа от удаляемого элемента - на одну ячейку влево с помощью System.arrayCopy();
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < position; index++) {
            if (this.items[index].getId().equals(id)) {
                result = true;
                System.arraycopy(this.items, index + 1,  this.items, index, position - index);
                position--;
                break;
            }
        }
        return result;
    }
    /**
     * Метод  возвращает копию массива this.items без null элементов;
     *
     * @return массив.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }
    /**
     * Метод проверяет в цикле все элементы массива this.items, сравнивая name (используя метод getName класса Item)
     * с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его;
     */
    public Item[] findByName(String key) {
        int counter = 0;
        Item[] tmp = new Item[this.position];
        for (int index = 0; index < position; index++) {
            if ((items[index] != null) && items[index].getName().equals(key)) {
                tmp[counter++] = items[index];
            }
        }
        return Arrays.copyOf(tmp, counter);
    }
    /**
     * Метод реализующий поиск заявки в хранилище
     *
     * @param id поиск заявки.
     * @return item.
     */
    public Item findById(String id) {
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