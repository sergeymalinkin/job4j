package stream.upgrade;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    @Test
    public void testLevelOf() {
        List<Student> studentList = Arrays.asList(
                new Student(80),
                new Student(40),
                new Student(50),
                new Student(30),
                null,
                new Student(70),
                null,
                new Student(90),
                new Student(0)
        );
        List<Student> expected = List.of(
                new Student(90),
                new Student(80),
                new Student(70)
        );
        List<Student> result = School.levelOf(studentList, 60);
        assertThat(result, is(expected));
    }
}