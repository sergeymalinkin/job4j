package lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 09.09.2019
 */
public class Calculator {

    public interface Operation {
        double calc(int left, int right);
    }
    /**
     * @param finish - финиш
     * @param value  - значение
     * @param op - операция
     */
    void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }
}







