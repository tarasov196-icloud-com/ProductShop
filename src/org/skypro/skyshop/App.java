package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

public class App {
    public static void main(String[] args) {


        SimpleProduct product1 = new SimpleProduct("Ноутбук", 114000);
        SimpleProduct product3 = new SimpleProduct("Наушники", 6500);
        FixPriceProduct product4 = new FixPriceProduct("Мышь");
        FixPriceProduct product5 = new FixPriceProduct("Клавиатура");
        DiscountedProduct product6 = new DiscountedProduct("Монитор", 31000,25);
        SimpleProduct product2 = new SimpleProduct("Смартфон", 155000);

        ProductBasket basket = new ProductBasket();


        basket.addProduct(product1);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        basket.addProduct(product6);
        basket.addProduct(product2);


        basket.printBasket();

        System.out.println("Общая стоимость корзины: " + basket.totalCostBasket());

        System.out.println("Есть ли 'Наушники' в корзине? " + basket.containsProductByName("Наушники"));

        System.out.println("Есть ли 'Монитор' в корзине? " + basket.containsProductByName("Монитор"));

        basket.clearBasket();
        System.out.println("\nКорзина после очистки:");

        basket.printBasket();

        System.out.println("Общая стоимость пустой корзины: " + basket.totalCostBasket());

        System.out.println("Есть ли 'Ноутбук' в пустой корзине? " + basket.containsProductByName("Ноутбук"));


    }
}