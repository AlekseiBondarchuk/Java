package exceptions;

public class Product {
    private String name;
    private int quantity;
    private double price;

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public double calculateTotalCost() throws InvalidQuantityException {
        if (quantity < 0) {
            throw new InvalidQuantityException("Недопустимое количество продуктов: " + quantity);
        }
        return quantity * price;
    }

    public int getAvailableQuantity() {
        return quantity;
    }
}