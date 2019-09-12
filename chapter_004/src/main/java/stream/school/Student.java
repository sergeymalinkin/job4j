package stream.school;

import java.util.Objects;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 10.09.2019
 */
class Student {
    private final int score;
    Student(int score) {
        this.score = score;
    }
    int getScore() {
        return score;
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
        return score == student.score;
    }
    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
    @Override
    public String toString() {
        return "Student{"
                +
                "score=" + score
                +
                '}';
    }
}
