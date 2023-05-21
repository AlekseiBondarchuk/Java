
import java.util.Arrays;
import java.util.Comparator;

public class Product {
    private String name;
    private boolean available;
    private double price;

    public Product() {
        // Конструктор по умолчанию
    }

    public Product(String name, boolean available, double price) {
        this.name = name;
        this.available = available;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public double getPrice() {
        return price;
    }

    public static void main(String[] args) {
        Product[] products = new Product[10];
        products[0] = new Product("Продукт 1", true, 10.99);
        products[1] = new Product("Продукт 2", false, 5.99);
        products[2] = new Product("Продукт 3", true, 8.99);
        products[3] = null;
        products[4] = new Product("Продукт 5", true, 12.99);
        products[5] = new Product("Продукт 6", true, 7.99);
        products[6] = new Product(); // Используем конструктор по умолчанию
        products[7] = new Product("Продукт 7", true, 9.99);
        products[8] = new Product("Продукт 8", false, 6.99);
        products[9] = new Product("Продукт 9", true, 11.99);

        // Сортировка массива по возрастанию цены
        Arrays.sort(products, Comparator.comparingDouble(Product::getPrice));

        // Выводим массив 3 раза
        for (int i = 0; i < 3; i++) {
            System.out.println("Итерация " + (i + 1));
            for (Product product : products) {
                if (product != null) {
                    System.out.println("Название: " + product.getName() +
                            ", Наличие: " + product.isAvailable() +
                            ", Цена: " + product.getPrice());
                } else {
                    System.out.println("Пустой продукт");
                }
            }
            System.out.println("---------------------");
        }

        // Сортировка массива по возрастанию названий продуктов
        Arrays.sort(products, Comparator.comparing(Product::getName));

        // Выводим массив 3 раза
        for (int i = 0; i < 3; i++) {
            System.out.println("Итерация " + (i + 1));
            for (Product product : products) {
                if (product != null) {
                    System.out.println("Название: " + product.getName() +
                            ", Наличие: " + product.isAvailable() +
                            ", Цена: " + product.getPrice());
                } else {
                    System.out.println("Пустой продукт");
                }
            }
            System.out.println("---------------------");
        }

        // Подсчет общей стоимости продуктов и количества продуктов в наличии
        double totalCost = 0;
        int availableProducts = 0;
        for (Product product : products) {
            if (product != null) {
                totalCost += product.getPrice();
                if (product.isAvailable()) {
                    availableProducts++;
                }
            }
        }

        System.out.println("Общая стоимость: " + totalCost);
        System.out.println("Продуктов в наличии: " + availableProducts);
    }
}