package ru.job4j.search;
import java.util.LinkedList;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
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
        int i = 0;
        while (i < this.tasks.size()) {
            if (task.getPriority() < this.tasks.get(i).getPriority()) {
                this.tasks.add(i, task);
                return;
            }
            i++;
        }
        this.tasks.add(task);
    }

    Task take() {
        return this.tasks.poll();
    }
}