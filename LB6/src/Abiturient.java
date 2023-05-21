import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Abiturient implements Comparable<Abiturient> {
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String address;
    private String phoneNumber;
    private List<Integer> grades;

    public Abiturient(int id, String lastName, String firstName, String patronymic, String address, String phoneNumber, List<Integer> grades) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.grades = grades;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public int getTotalGrade() {
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return total;
    }

    @Override
    public int compareTo(Abiturient other) {
        return this.getLastName().compareTo(other.getLastName());
    }

    @Override
    public String toString() {
        return "Abiturient{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", grades=" + grades +
                '}';
    }
}
