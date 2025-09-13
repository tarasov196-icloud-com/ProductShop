package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым или состоять только из пробелов");
        }
        this.name = name;
    }

    public String getSearchTerm() {
        return getName();
    }

    public String getContentType() {
        return "PRODUCT";
    }

    public abstract int getPrice();

    public boolean isSpecial() {
        return false;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // сравнение с самим собой
        if (o == null || getClass() != o.getClass()) return false; // проверка типа
        Product product = (Product) o;
        return name.equals(product.name); // сравниваем только имя
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}