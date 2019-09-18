package ru.job4j.pojo;

/**
 * Удаление моделей из массива - выполнение задания.
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 18.09.2019
 */
public class Shop {
    Product[] delete(Product[] products, int index) {
        System.out.println();
        System.out.println("Удаляем значение из ячейки с индексом " + index);
        products[index] = null;
        for (int i = index; i < products.length - 1; i++) {
            Product product = products[i + 1];
            //проверяем, что объект не равен null. тк у нас массив не заполнен целиком.
            if (product != null) {
                products[i] = products[i + 1];
            } else {
                System.out.println("null");
            }
        }
        System.out.println("Массив после удаления:");
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
        return products;
    }
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (Product product : products) {
            //проверяем, что объект не равен null. тк у нас массив не заполнен целиком.
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}


