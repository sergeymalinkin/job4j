package lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 09.09.2019
 */
class CountFunction {
    /**
     * Метод подсчета функций в диапозоне.
     *
     * @param start - старт
     * @param end   - финиш
     * @param func  - функция
     * @return результат
     */
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> functions = new ArrayList<>();
        for (int index = start; index <= end; index++) {
            functions.add(func.apply((double) index));
        }
        return functions;
    }
}



