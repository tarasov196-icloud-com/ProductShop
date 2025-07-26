package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int counter;

    public ProductBasket() {
        this.products = new Product[5];
        this.counter = 0;
    }

    public void addProduct(Product product) {
        if (counter < products.length) {
            products[counter] = product;
            counter++;
        } else {
            System.out.println("В корзине нет места");
        }
    }

    public int totalCostBasket() {
        int total = 0;
        for (int i = 0; i < counter; i++) {
            if (products[i] != null) {  // Защита от null
                total += (int) products[i].getPrice();
            }
        }
        return total;
    }


    public void printBasket() {
        if (counter == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        System.out.println("Содержимое корзины:");

        int specialCount = 0;
        for (int i = 0; i < counter; i++) {


            System.out.println(products[i]);
            if (products[i].isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Total cost basket: " + totalCostBasket());
        System.out.println("Специальных товаров: " + specialCount);
    }


    public boolean containsProductByName(String name) {
        for (int i = 0; i < counter; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        counter = 0;
    }
}