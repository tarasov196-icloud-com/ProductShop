package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public String getSearchTerm() {
        return getName();
    }

    public String getContentType() {
        return "PRODUCT";
    }

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

