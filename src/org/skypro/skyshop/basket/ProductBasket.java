package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {

    private final Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (product == null) return;
        String name = product.getName();
        products.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
    }

    public int totalCostBasket() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .mapToInt(p -> (int) p.getPrice())
                .sum();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        System.out.println("Содержимое корзины:");
        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        long specialCount = products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();

        System.out.println("Total cost basket: " + totalCostBasket());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProductByName(String name) {
        return products.containsKey(name);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removed = products.remove(name);
        return removed != null ? removed : new ArrayList<>();
    }

    public void clearBasket() {
        products.clear();
    }

    public List<Product> getProducts() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
