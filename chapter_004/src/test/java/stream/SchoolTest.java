package stream;
import org.junit.Test;
import java.util.List;
import java.util.function.Predicate;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 10.09.2019
 */
public class SchoolTest {
    @Test
    public void whenFilterForListClassA() {
        List<Student> students = List.of(
        new Student(90),
        new Student(85),
        new Student(80),
        new Student(75),
        new Student(73),
        new Student(70)
        );
        School school = new School();
        Predicate<Student> condition1 = p -> p.getScore() >= 70 && p.getScore() <= 100;
        List<Student> classA = school.collect(students, condition1);
        List<Student> expectedA = List.of(
                new Student(90),
                new Student(85),
                new Student(80),
                new Student(75),
                new Student(73),
                new Student(70)
        );
        assertThat(classA, is(expectedA));
    }
    @Test
    public void whenFilterForListClassB() {
        List<Student> students = List.of(
                new Student(70),
                new Student(65),
                new Student(63),
                new Student(60),
                new Student(55),
                new Student(50)
        );
        Predicate<Student> condition2 = p -> p.getScore() >= 50 && p.getScore() <= 70;
        School school = new School();
        List<Student> classB = school.collect(students, condition2);
        List<Student> expectedB = List.of(
                new Student(70),
                new Student(65),
                new Student(63),
                new Student(60),
                new Student(55),
                new Student(50)
        );
        assertThat(classB, is(expectedB));
    }
    @Test
    public void whenFilterForListClassC() {
        List<Student> students = List.of(
                new Student(50),
                new Student(47),
                new Student(45),
                new Student(40),
                new Student(30),
                new Student(20)
        );
        Predicate<Student> condition3 = p -> p.getScore() >= 0 && p.getScore() <= 50;
        School school = new School();
        List<Student> classC = school.collect(students, condition3);
        List<Student> expectedC = List.of(
                new Student(50),
                new Student(47),
                new Student(45),
                new Student(40),
                new Student(30),
                new Student(20)
        );
        assertThat(classC, is(expectedC));
    }
}
