package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPercent;

    public DiscountedProduct(String name, int basePrice,
                             int discountPercent) {
        super(name);
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    public int getPrice() {
        return basePrice * (100 - discountPercent) / 100;
    }

    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        return super.getName() + ": " + getPrice() +
                " (" + discountPercent + "%)";
    }
}
