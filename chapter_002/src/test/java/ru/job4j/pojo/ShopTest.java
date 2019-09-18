package ru.job4j.pojo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ShopTest {
    @Test
    public void testDelete() {
       Shop shop = new Shop();
       Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        Product[] expected = {products[0], products[1], products[2], null, null};
        Product[] test = shop.delete(products, 3);
        assertThat(test, is(expected));
    }
}