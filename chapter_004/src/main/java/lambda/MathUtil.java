package lambda;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 09.09.2019
 */
public class MathUtil {
    static double add(int left, int second) {
        return left + second;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiple(
                0, 10, 2,
                MathUtil::add,
                System.out::println
        );
    }
}

