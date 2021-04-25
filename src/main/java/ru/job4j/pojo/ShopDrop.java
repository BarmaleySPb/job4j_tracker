package ru.job4j.pojo;

public class ShopDrop {

    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = index; i < products.length; i++) {
            if (i + 1 < products.length && products[i + 1] != null) {
                products[i] = products[i + 1];
            } else {
                products[i] = null;
            }
        }
        return products;
    }
}
