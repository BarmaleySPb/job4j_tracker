package ru.job4j.pojo;

public class Shop {

    public static int indexOfNull(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("milk", 10);
        products[1] = new Product("bread", 4);
        products[2] = new Product("egg", 19);
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName());
            }
        }
        System.out.println("Index of first element with \"null\": " + indexOfNull(products));
    }
}
