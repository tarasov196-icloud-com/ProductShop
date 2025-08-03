package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть строго больше 0");
        }
        this.price = price;
    }


    @Override
    public String toString() {
        return super.toString() + ": " + price;
    }

        public int getPrice () {
            return price;
        }
    }
