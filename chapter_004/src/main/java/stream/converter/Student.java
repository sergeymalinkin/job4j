package stream.converter;

import java.util.Objects;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 10.09.2019
 */
class Student {
    private final String secondName;
    private final int score;
    Student(String secondName, int score) {
        this.secondName = secondName;
        this.score = score;
    }
    String getSecondName() {
        return secondName;
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
        return score == student.score
                &&
                Objects.equals(secondName, student.secondName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(score, secondName);
    }
    @Override
    public String toString() {
        return "Student{"
                +
                "secondName='" + secondName + '\''
                +
                ", score=" + score
                +
                '}';
    }
}