import exceptions.InvalidQuantityException;
import exceptions.Product;

public class Main {
    public static void main(String[] args) {
        try {
            Product product1 = new Product("Телефон", 10, 1000.0);
            Product product2 = new Product("Наушники", 5, 50.0);

            double totalCost1 = product1.calculateTotalCost();
            int availableQuantity1 = product1.getAvailableQuantity();

            double totalCost2 = product2.calculateTotalCost();
            int availableQuantity2 = product2.getAvailableQuantity();

            System.out.println("Общая стоимость продуктов 1: " + totalCost1);
            System.out.println("Количество продуктов 1 в наличии: " + availableQuantity1);

            System.out.println("Общая стоимость продуктов 2: " + totalCost2);
            System.out.println("Количество продуктов 2 в наличии: " + availableQuantity2);
        } catch (InvalidQuantityException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}