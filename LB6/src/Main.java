import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Abiturient> abiturients = readAbiturientsFromFile("input.txt");

        // Вывод списка абитуриентов с неудовлетворительными оценками
        List<Abiturient> unsatisfactoryGradesAbiturients = getAbiturientsWithUnsatisfactoryGrades(abiturients);
        System.out.println("Список абитуриентов с неудовлетворительными оценками:");
        for (Abiturient abiturient : unsatisfactoryGradesAbiturients) {
            System.out.println(abiturient);
        }

        // Вывод списка абитуриентов с суммой баллов выше заданной
        int minimumTotalGrade = 150; // Заданное значение для суммы баллов
        List<Abiturient> abiturientsWithHigherTotalGrade = getAbiturientsWithHigherTotalGrade(abiturients, minimumTotalGrade);
        System.out.println("\nСписок абитуриентов с суммой баллов выше " + minimumTotalGrade + ":");
        for (Abiturient abiturient : abiturientsWithHigherTotalGrade) {
            System.out.println(abiturient);
        }

        // Выбор заданного числа абитуриентов с самой высокой суммой баллов
        int numberOfTopAbiturients = 3; // Заданное число абитуриентов
        List<Abiturient> topAbiturients = getTopAbiturients(abiturients, numberOfTopAbiturients);
        System.out.println("\nСписок " + numberOfTopAbiturients + " абитуриентов с самой высокой суммой баллов:");
        for (Abiturient abiturient : topAbiturients) {
            System.out.println(abiturient);
        }
    }

    private static List<Abiturient> readAbiturientsFromFile(String fileName) {
        // Реализуйте чтение абитуриентов из файла и создание объектов класса Abiturient
        // Для простоты примера, здесь будет использована заглушка
        List<Abiturient> abiturients = new ArrayList<>();
        abiturients.add(new Abiturient(1, "Иванов", "Иван", "Иванович", "ул. Пушкина 1", "123456789", List.of(80, 90, 75)));
        abiturients.add(new Abiturient(2, "Петров", "Петр", "Петрович", "ул. Лермонтова 2", "987654321", List.of(85, 95, 70)));
        abiturients.add(new Abiturient(3, "Сидоров", "Сидор", "Сидорович", "ул. Гоголя 3", "456789123", List.of(90, 80, 85)));
        return abiturients;
    }

    private static List<Abiturient> getAbiturientsWithUnsatisfactoryGrades(List<Abiturient> abiturients) {
        List<Abiturient> result = new ArrayList<>();
        for (Abiturient abiturient : abiturients) {
            boolean hasUnsatisfactoryGrade = false;
            for (int grade : abiturient.getGrades()) {
                if (grade < 60) {
                    hasUnsatisfactoryGrade = true;
                    break;
                }
            }
            if (hasUnsatisfactoryGrade) {
                result.add(abiturient);
            }
        }
        return result;
    }

    private static List<Abiturient> getAbiturientsWithHigherTotalGrade(List<Abiturient> abiturients, int minimumTotalGrade) {
        List<Abiturient> result = new ArrayList<>();
        for (Abiturient abiturient : abiturients) {
            int totalGrade = abiturient.getTotalGrade();
            if (totalGrade > minimumTotalGrade) {
                result.add(abiturient);
            }
        }
        return result;
    }

    private static List<Abiturient> getTopAbiturients(List<Abiturient> abiturients, int numberOfTopAbiturients) {
        List<Abiturient> sortedAbiturients = new ArrayList<>(abiturients);
        Collections.sort(sortedAbiturients, Collections.reverseOrder());
        return sortedAbiturients.subList(0, Math.min(numberOfTopAbiturients, sortedAbiturients.size()));
    }
}