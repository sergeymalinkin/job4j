package ru.job4j.singleton;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TrackerSingletonTest {

    @Test
    public void whenEnum() {
        TrackerEnum trackerFirst = TrackerEnum.INSTANCE;
        TrackerEnum trackerSecond = TrackerEnum.INSTANCE;
        assertThat(trackerFirst.toString(), is(trackerSecond.toString()));
    }
    @Test
    public void whenStatic() {
        TrackerStatic trackerFirst = TrackerStatic.getInstance();
        TrackerStatic trackerSecond = TrackerStatic.getInstance();
        assertThat(trackerFirst.toString(), is(trackerSecond.toString()));
    }
    @Test
    public void whenStaticFinal() {
        TrackerStaticFinal trackerFirst = TrackerStaticFinal.getInstance();
        TrackerStaticFinal trackerSecond = TrackerStaticFinal.getInstance();
        assertThat(trackerFirst.toString(), is(trackerSecond.toString()));
    }
    @Test
    public void whenSingle() {
        TrackerSingle trackerFirst = TrackerSingle.getInstance();
        TrackerSingle trackerSecond = TrackerSingle.getInstance();
        assertThat(trackerFirst.toString(), is(trackerSecond.toString()));
    }
}