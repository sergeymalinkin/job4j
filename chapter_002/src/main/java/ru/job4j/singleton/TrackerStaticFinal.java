package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

class TrackerStaticFinal {
    private static final TrackerStaticFinal INSTANCE = new TrackerStaticFinal();

    Tracker tracker = new Tracker();

    private TrackerStaticFinal() {
    }

//    @Contract(pure = true)
    static TrackerStaticFinal getInstance() {
        return INSTANCE;
    }
}
