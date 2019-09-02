package ru.job.search;

import java.util.LinkedList;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 02.09.2019
 */
class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставики использовать add(int index, E value)
     * @param task задача
     */
    void put(Task task) {
        //добавить вставку в связанный список.
    }

    Task take() {
        return this.tasks.poll();
    }
}


