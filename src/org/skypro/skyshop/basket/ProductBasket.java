package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.*;

public class ProductBasket {

    private final Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }


    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        String name = product.getName();
        products.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
    }


    public int totalCostBasket() {
        int total = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    total += (int) product.getPrice();
                }
            }
        }
        return total;
    }


    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        System.out.println("Содержимое корзины:");
        int specialCount = 0;
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            for (Product product : entry.getValue()) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Total cost basket: " + totalCostBasket());
        System.out.println("Специальных товаров: " + specialCount);
    }


    public boolean containsProductByName(String name) {
        return products.containsKey(name);
    }

    public List<Product> removeProductsByName(String name) {
        return products.getOrDefault(name, new ArrayList<>());
    }


    public void clearBasket() {
        products.clear();
    }

    public List<Product> getProducts() {
        List<Product> allProducts = new ArrayList<>();
        for (List<Product> productList : products.values()) {
            allProducts.addAll(productList);
        }
        return allProducts;
    }
}