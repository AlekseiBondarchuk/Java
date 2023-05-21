import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class ProductSerializer {
    public static void serialize(Product product, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Product deserialize(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (Product) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class ProductManager {
    public static Product createProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название продукта: ");
        String name = scanner.nextLine();
        System.out.print("Введите количество: ");
        int quantity = scanner.nextInt();
        System.out.print("Введите цену: ");
        double price = scanner.nextDouble();
        return new Product(name, quantity, price);
    }

    public static void saveProducts(List<Product> products, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> loadProducts(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Product>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

