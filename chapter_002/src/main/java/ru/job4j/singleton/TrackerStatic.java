package ru.job4j.singleton;

import ru.job4j.tracker.Tracker;

class TrackerStatic {
    private static TrackerStatic instance;
    Tracker tracker = new Tracker();

    private TrackerStatic() {
    }

    static TrackerStatic getInstance() {
        if (instance == null) {
            instance = new TrackerStatic();
        }
        return instance;
    }
}
