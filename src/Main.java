import java.sql.SQLOutput;

public class Main {
    public static Employee[] employees = new Employee[10];
    public static void main(String[] args) {


        employees[0] = new Employee("Ivanov", "Ivan", "Ivanovich"
                , 1, 80000);
        employees[1] = new Employee("Petrov", "Petr", "Petrovich"
                , 2, 50000);
        employees[2] = new Employee("Alekseev", "Aleksey", "Alekseevich"
                , 2, 50000);
        employees[3] = new Employee("Andreev", "Andrey", "Andreevich"
                , 1, 80000);
        employees[4] = new Employee("Petrov", "Aleksey", "Victorovich"
                , 5, 150000);
        employees[5] = new Employee("Ivanova", "Irina", "Alekseevna"
                , 4, 100000);
        employees[6] = new Employee("Andreeva", "Uliya", "Igorevna"
                , 4, 100000);
        employees[7] = new Employee("Ilyin", "Andrey", "Vladimirovich"
                , 3, 75000);
        employees[8] = new Employee("Repin", "Andrey", "Petrovich"
                , 3, 75000);
        employees[9] = new Employee("Levin", "Vladimir", "Nikolaevich"
                , 3, 75000);

//        Проверка вывода в консоль:
        showListEmployees();
        System.out.println("\nСумма затрат на зарплаты в месяц: " + getMonthCost());
        findMinSalary();
        findMaxSalary();
        System.out.println("\nСреднее значение зарплат в месяц: " + calculateAverageMonthCost());
        showListEmployeesNames();
        indexSalary(5);
        showListEmployees();
        findMinSalaryByDivision(2);
        findMaxSalaryByDivision(5);
        getMonthCostByDivision(3);
        System.out.println("\nСредняя зарплата по отделу: " + calculateAverageMonthCostByDivision(3));
        indexSalaryByDivision(2, 10);
        showListEmployeesByDivision(2);
        findSalaryBelowValue(100000);
        findSalaryAboveValue(100000);
    }

    public static void showListEmployees() {
        System.out.println("\nСписок сотрудников:");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());
        }
    }

    public static int getMonthCost() {
        var sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public static void findMinSalary() {
        System.out.println("\nСотрудники с минимальной зарплатой:");
        var n = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (n > employees[i].getSalary()) {
                n = employees[i].getSalary();
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (n == employees[i].getSalary()) {
                System.out.println(employees[i].toString());
            }
        }
    }

    public static void findMaxSalary() {
        System.out.println("\nСотрудники с максимальной зарплатой:");
        var n = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (n < employees[i].getSalary()) {
                n = employees[i].getSalary();
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (n == employees[i].getSalary()) {
                System.out.println(employees[i].toString());
            }
        }
    }

    public static int calculateAverageMonthCost() {
        return getMonthCost() / employees.length;
    }
    public static void showListEmployeesNames() {
        System.out.println("\nФ.И.О. сотрудников:");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getLastName() +
                    " " + employees[i].getFirstName() +
                    " " + employees[i].getMiddleName());
        }
    }

    public static void indexSalary(int increment) {
        for (int i = 0; i < employees.length; i++) {
            employees[i].indexSalary(increment);
        }
    }

    public static void findMinSalaryByDivision(int division) {
        System.out.println("\nСотрудники отдела " + division + " с минимальной зарплатой:");
        var n = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDivision() == division && n > employees[i].getSalary()) {
                n = employees[i].getSalary();
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDivision() == division && n == employees[i].getSalary()) {
                System.out.println(employees[i].toString());
            }
        }
    }
    public static void findMaxSalaryByDivision(int division) {
        System.out.println("\nСотрудники отдела " + division + " с максимальной зарплатой:");
        var n = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDivision() == division && n < employees[i].getSalary()) {
                n = employees[i].getSalary();
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDivision() == division && n == employees[i].getSalary()) {
                System.out.println(employees[i].toString());
            }
        }
    }
    public static void getMonthCostByDivision(int division) {
        var sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDivision() == division) {
                sum += employees[i].getSalary();
            }
        }
        System.out.println("\nСумма затрат на зарплаты отдела " + division + " в месяц: " + sum);
    }
    public static int calculateAverageMonthCostByDivision(int division) {
        int count = 0;
        var sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDivision() == division) {
                count++;
                sum += employees[i].getSalary();
            }
        }
        if (count != 0) {
            return sum / count;
        } else {
            return  0;
        }
    }

    public static void indexSalaryByDivision(int division, int increment) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDivision() == division) {
                employees[i].indexSalary(increment);
            }
        }
    }

    public static void showListEmployeesByDivision(int division) {
        System.out.println("\nСписок сотрудников отдела " + division + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDivision() == division) {
                System.out.println(employees[i].toStringByDivision());
            }
        }
    }

    public static void findSalaryBelowValue(int val) {
        System.out.println("\nСотрудники с зарплатой менее " + val + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < val) {
                System.out.println(employees[i].toStringByDivision());
            }
        }
    }
    public static void findSalaryAboveValue(int val) {
        System.out.println("\nСотрудники с зарплатой выше " + val + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > val) {
                System.out.println(employees[i].toStringByDivision());
            }
        }
    }
}