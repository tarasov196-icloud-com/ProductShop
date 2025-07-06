package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String name, int price) {
        super(name);
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
