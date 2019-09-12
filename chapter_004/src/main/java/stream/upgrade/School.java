package stream.upgrade;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 12.09.2019
 */


class School {
    static List<Student> levelOf(List<Student> students, int bound) {
    return students.stream().flatMap(Stream :: ofNullable)
            .sorted((o1, o2) -> o2.getScope().compareTo(o1.getScope()))
            .takeWhile(s -> s.getScope() > bound)
            .collect(Collectors.toList());
    }
}
