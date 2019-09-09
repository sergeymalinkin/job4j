package lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 09.09.2019
 */
public class Calculator {
    /**
     * @param finish - финиш
     * @param value  - значение
     * @param op - операция
     */
    void multiple(int finish, int value,
                  BiFunction<Integer, Integer, Double> op,
                  Consumer<Double> media) {
        for (int index = 0; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }

    /**
     * Вывод результатов
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiple(
                10, 2,
                (value, index) -> {
                    double result = value * index;
                    System.out.printf("Multiple %s * %s = %s %n", value, index, result);
                    return result;
                },
                System.out::println
        );
    }
}






