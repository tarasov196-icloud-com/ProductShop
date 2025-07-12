package org.skypro.skyshop.product;

public abstract class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public abstract int getPrice();

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return name;

    }

    public String getName() {
        return name;
    }


}

