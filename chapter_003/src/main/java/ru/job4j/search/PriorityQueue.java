package ru.job4j.search;

import java.util.LinkedList;
import java.util.ListIterator;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 2.0
 * @since 02.09.2019
 */
class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    /**
     * Метод вставляет элемент в нужную позицию.
     * Позиция определятся по полю приоритет.
     * @param task задача
     */
    void put(Task task) {
        ListIterator<Task> liter = tasks.listIterator();
        var count = tasks.size();
        for (var index = 0; index < tasks.size(); index++) {
            if (task.getPriority() < liter.next().getPriority()) {
                count = index;
                break;
            }
        }
        tasks.add(count, task);
    }
    Task take() {
        return this.tasks.poll();
    }
}
