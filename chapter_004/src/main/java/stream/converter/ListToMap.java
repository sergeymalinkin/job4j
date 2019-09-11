package stream.converter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 10.09.2019
 */
class ListToMap {
    Map<String, Student> convert(List<Student> students) {
        return students.stream().collect(Collectors.toMap(Student::getSecondName, s -> s));
    }
}
