package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPercent;

    public DiscountedProduct(String name, int basePrice,
                             int discountPercent) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена продукта должна быть строго больше 0");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100 включительно");
        }
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
