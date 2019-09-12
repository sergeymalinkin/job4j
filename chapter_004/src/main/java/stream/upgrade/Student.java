package stream.upgrade;

import java.util.Objects;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 10.09.2019
 */
class Student  {
    private final Integer scope;


    Student(Integer scope) {
        this.scope = scope;
    }

    Integer getScope() {
        return scope;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return scope.equals(student.scope);
    }
    @Override
    public int hashCode() {
        return Objects.hash(scope);
    }
}
