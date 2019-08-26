package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();
    /**
     * Конструктор.
     *
     * @param input объект типа Input
     * @param tracker объект типа Tracker
     */
    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    int getActionsLength() {
        return this.actions.size();
    }
    /**
     * Метод заполняет массив.
     */
    void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Добавление новой заявки"));
        this.actions.add(new ShowItems(1, "Отобразить все заявки"));
        this.actions.add(new EditItem(2, "Замена заявки"));
        this.actions.add(new DeleteItem(3, "Удаление заявки"));
        this.actions.add(new FindItemById(4, "Поиск заявки по ID"));
        this.actions.add(new FindItemByName(5, "Поиск заявки по имени"));
        this.actions.add(new ExitProgram(6, "Выход", ui));
    }
    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    /**
     * Метод выводит на экран меню.
     */
    void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}