public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Ivanov", "Ivan", "Ivanovich", 1, 80000);
        employees[1] = new Employee("Petrov", "Petr", "Petrovich", 2, 50000);
        employees[2] = new Employee("Alekseev", "Aleksey", "Alekseevich", 2, 50000);
        employees[3] = new Employee("Andreev", "Andrey", "Andreevich", 1, 80000);
        employees[4] = new Employee("Petrov", "Aleksey", "Victorovich", 5, 150000);
        employees[5] = new Employee("Ivanova", "Irina", "Alekseevna", 4, 100000);
        employees[6] = new Employee("Andreeva", "Uliya", "Igorevna", 4, 100000);
        employees[7] = new Employee("Ilyin", "Andrey", "Vladimirovich", 3, 75000);
        employees[8] = new Employee("Repin", "Andrey", "Petrovich", 3, 75000);
        employees[9] = new Employee("Levin", "Vladimir", "Nikolaevich", 3, 75000);

        listEmployees(employees);
        getMonthCost(employees);
    }

    public static void listEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (i == 0) {
                System.out.println("Список сотрудников:");
            }
        System.out.println(employees[i].toString());
        }
    }

    public static void getMonthCost(Employee[] employees) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        System.out.println("Сумма затрат на зарплаты в месяц: " + sum);
    }

    public static void findMinSalary(Employee[] employees) {
        int n = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (n > employees[i].getSalary()) {
                n = employees[i].getSalary();
            } else if (n == employees[i].getSalary()) {
                System.out.println();
            }
        }
    }
}