import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Employee IvanovI = new Employee("Ivanov", "Ivan", "Ivanovich", 1, 80000);

//        System.out.println(IvanovI.toString());

        Employee PetrovP = new Employee("Petrov", "Petr", "Petrovich", 2, 50000);

        System.out.println(PetrovP.toString());

        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Ivanov", "Ivan", "Ivanovich", 1, 80000);
        employees[1] = new Employee("Petrov", "Petr", "Petrovich", 2, 50000);
    }
}