import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product implements Serializable {
    private String name;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotalCost() {
        return quantity * price;
    }

    public static int getTotalQuantity(List<Product> products) {
        int totalQuantity = 0;
        for (Product product : products) {
            totalQuantity += product.quantity;
        }
        return totalQuantity;
    }
}
