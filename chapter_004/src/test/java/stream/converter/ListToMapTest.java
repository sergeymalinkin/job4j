package stream.converter;
import org.junit.Test;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 10.09.2019
 */
public class ListToMapTest {
    @Test
    public void whenListToMap() {
        ListToMap convertList = new ListToMap();
        List<Student> students = List.of(
                new Student("Анфалов", 50),
                new Student("Мимов", 70),
                new Student("Булгаков", 90),
                new Student("Пресниченко", 80),
                new Student("Тузова", 80)
        );
        Map<String, Student> result = convertList.convert(students);
        Map<String, Student> expected = Map.of("Анфалов", new Student("Анфалов", 50),
                "Мимов", new Student("Мимов", 70),
                "Булгаков", new Student("Булгаков", 90),
                "Пресниченко", new Student("Пресниченко", 80),
                "Тузова", new Student("Тузова", 80));
        assertThat(result, is(expected));
    }
}