package ru.job4j.oop.kolobok;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 18.09.2019
 */
public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Wolf wolf = new Wolf();
        Bear bear = new Bear();
        Fox fox = new Fox();

        System.out.println("СКАЗКА ПРО КОЛОБКА!");
        ball.sing(ball);
        wolf.tryEat(ball);
        bear.tryEat(ball);
        fox.tryEat(ball);
        System.out.println("КОНЕЦ!!!");

    }
}
