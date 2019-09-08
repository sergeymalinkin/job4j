package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class TrackerSingle {

//    @Contract(pure = true)
    private TrackerSingle() {
    }

//    @org.jetbrains.annotations.Contract(pure = true)
    static TrackerSingle getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSingle INSTANCE = new TrackerSingle();
    }

    public static void main(String[] args) {
        TrackerSingle tracker = TrackerSingle.getInstance();
    }

}
