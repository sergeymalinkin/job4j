package stream.converter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 11.09.2019
 */
class MatrixToList {
    /**
     * Метод преобразования массива чисел в список чисел
     * @param matrix - матрица чисел
     * @return список чисел
     */
    List<Integer> convert(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(Arrays:: stream).collect(Collectors.toList());
    }
}
