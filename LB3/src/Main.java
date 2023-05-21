import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

        public static void main(String[] args) {
            // Создание списка продуктов
            List<Product> products = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Product product = ProductManager.createProduct();
                products.add(product);
            }

            // Сохранение списка продуктов в файл
            ProductManager.saveProducts(products, "products.dat");

            // Загрузка списка продуктов из файла
            List<Product> loadedProducts = ProductManager.loadProducts("products.dat");

            // Вывод общей стоимости продуктов
            double totalCost = 0;
            for (Product product : loadedProducts) {
                totalCost += product.getTotalCost();
            }
            System.out.println("Общая стоимость продуктов: " + totalCost);

            // Вывод общего количества продуктов
            int totalQuantity = Product.getTotalQuantity(loadedProducts);
            System.out.println("Общее количество продуктов: " + totalQuantity);
        }
    }
