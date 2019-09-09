package lambda;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * @author Sergey Malinkin (mailto:sloyz@ya.ru)
 * @version 1
 * @since 09.09.2019
 */
public class CountFunctionTest {
    /**
     * Реализация линейной функции
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        CountFunction calc = new CountFunction();
        List<Double> result = calc.diapason(5, 8,
                x -> x
        );
        List<Double> expected = Arrays.asList(5D, 6D, 7D, 8D);
        assertThat(result, is(expected));
    }
    /**
     * Реализация квадратичной функции
     */
    @Test
    public void whenSquaredFromOneToSix() {
        CountFunction calc = new CountFunction();
        List<Double> result = calc.diapason(5, 8,
                x -> x * x
        );
        List<Double> expected = Arrays.asList(25D, 36D, 49D, 64D);
        assertThat(result, is(expected));
    }
    /**
     * Реализация логарифмической функции
     */
    @Test
    public void whenLogFromOneToTree() {
        CountFunction calc = new CountFunction();
        List<Double> result = calc.diapason(1, 3,
                Math::log
        );
        List<Double> expected = Arrays.asList(0D, 0.6931471805599453D, 1.0986122886681098D);
        assertThat(result, is(expected));
    }
}
