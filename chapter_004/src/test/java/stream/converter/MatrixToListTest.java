package stream.converter;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 11.09.2019
 */
public class MatrixToListTest {
    /**
     * Тест преобразования матрциы чисел в список чисел.
     */
    @Test
    public void whenMatrixToList() {
        MatrixToList convertList = new MatrixToList();
        Integer[][] matrix = {{2, 4, 6}, {8, 10, 12}};
        List<Integer> result = convertList.convert(matrix);
        List<Integer> expected = List.of(2, 4, 6, 8, 10, 12);
        assertThat(result, is(expected));
    }
}
