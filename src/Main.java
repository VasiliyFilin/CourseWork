public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[10];
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
        showListEmployees(employees);
        getMonthCost(employees);
        findMinSalary(employees);
        findMaxSalary(employees);
        calculateAverageMonthCost(employees);
        showListEmployeesNames(employees);
        indexSalary(employees, 5);
        showListEmployees(employees);
        findMinSalaryByDivision(employees, 2);
        findMaxSalaryByDivision(employees, 5);
        getMonthCostByDivision(employees, 3);
        calculateAverageMonthCostByDivision(employees, 3);
        indexSalaryByDivision(employees, 2, 10);
        showListEmployeesByDivision(employees, 2);
        findSalaryBelowValue(employees, 100000);
        findSalaryAboveValue(employees, 100000);
    }

    public static void showListEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (i == 0) {
                System.out.println("\nСписок сотрудников:");
            }
            System.out.println(employees[i].toString());
        }
    }

    private static int salarySum;

    public static void getMonthCost(Employee[] employees) {
        var sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        System.out.println("\nСумма затрат на зарплаты в месяц: " + sum);
        salarySum = sum;
    }

    public static void findMinSalary(Employee[] employees) {
        var n = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (n > employees[i].getSalary()) {
                n = employees[i].getSalary();
            }
        }
        System.out.println("\nСотрудники с минимальной зарплатой:");
        for (int i = 0; i < employees.length; i++) {
            if (n == employees[i].getSalary()) {
                System.out.println(employees[i].toString());
            }
        }
    }

    public static void findMaxSalary(Employee[] employees) {
        var n = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (n < employees[i].getSalary()) {
                n = employees[i].getSalary();
            }
        }
        System.out.println("\nСотрудники с максимальной зарплатой:");
        for (int i = 0; i < employees.length; i++) {
            if (n == employees[i].getSalary()) {
                System.out.println(employees[i].toString());
            }
        }
    }

    public static void calculateAverageMonthCost(Employee[] employees) {
        var s = salarySum / employees.length;
        System.out.println("\nСреднее значение зарплат в месяц: " + s);
    }
    public static void showListEmployeesNames(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (i == 0) {
                System.out.println("\nФ.И.О. сотрудников:");
            }
            System.out.println(employees[i].getLastName() +
                    " " + employees[i].getFirstName() +
                    " " + employees[i].getMiddleName());
        }
    }

    public static void indexSalary(Employee[] employees, int increment) {
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary(employees[i].indexSalary(employees[i].getSalary(), increment));
        }
    }

    public static void findMinSalaryByDivision(Employee[] employees, int division) {
        var n = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDivision() == division && n > employees[i].getSalary()) {
                n = employees[i].getSalary();
            }
        }
        System.out.println("\nСотрудники отдела " + division + " с минимальной зарплатой:");
        for (int i = 0; i < employees.length; i++) {
            if (n == employees[i].getSalary()) {
                System.out.println(employees[i].toString());
            }
        }
    }
    public static void findMaxSalaryByDivision(Employee[] employees, int division) {
        var n = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDivision() == division && n < employees[i].getSalary()) {
                n = employees[i].getSalary();
            }
        }
        System.out.println("\nСотрудники отдела " + division + " с максимальной зарплатой:");
        for (int i = 0; i < employees.length; i++) {
            if (n == employees[i].getSalary()) {
                System.out.println(employees[i].toString());
            }
        }
    }
    public static void getMonthCostByDivision(Employee[] employees, int division) {
        var sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDivision() == division) {
                sum += employees[i].getSalary();
            }
        }
        System.out.println("\nСумма затрат на зарплаты отдела " + division + " в месяц: " + sum);
    }
    public static void calculateAverageMonthCostByDivision(Employee[] employees, int division) {
        int count = 0;
        var sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDivision() == division) {
                count++;
                sum += employees[i].getSalary();
            }
        }
        System.out.println("\nСреднее значение зарплат по отделу " + division + " в месяц: " + sum / count);
    }

    public static void indexSalaryByDivision(Employee[] employees, int division, int increment) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDivision() == division) {
                employees[i].setSalary(employees[i].indexSalary(employees[i].getSalary(), increment));
            }
        }
    }

    public static void showListEmployeesByDivision(Employee[] employees, int division) {
        for (int i = 0; i < employees.length; i++) {
            if (i == 0) {
                System.out.println("\nСписок сотрудников отдела " + division + ":");
            }
            if (employees[i].getDivision() == division) {
                System.out.println(employees[i].toStringByDivision());
            }
        }
    }

    public static void findSalaryBelowValue(Employee[] employees, int val) {
        System.out.println("\nСотрудники с зарплатой менее " + val + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < val) {
                System.out.println(employees[i].toStringByDivision());
            }
        }
    }
    public static void findSalaryAboveValue(Employee[] employees, int val) {
        System.out.println("\nСотрудники с зарплатой выше " + val + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > val) {
                System.out.println(employees[i].toStringByDivision());
            }
        }
    }
}