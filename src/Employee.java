public class Employee {
    private String firstName;
    private String middleName;
    private String lastName;
    private int division;
    private int salary;
    private static int idCounter = 1;
    private int id;

    private static int increment;

    public Employee(String lastName, String firstName, String middleName, int division, int salary) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.division = division;
        this.salary = salary;
        this.id = idCounter;
        idCounter++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDivision() {
        return division;
    }

    public int getSalary() {
        return salary;
    }
    public int getId() {
        return id;
    }

    public String toStringByDivision() {
        return "id: " + id +
                ", Ф.И.О - " + firstName + " " + middleName + " " + lastName +
                ", Зарплата - " + salary;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", Ф.И.О - " + firstName + " " + middleName + " " + lastName +
                ", Отдел - " + division +
                ", Зарплата - " + salary;
    }


    public void setDivision(int division) {
        this.division = division;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int indexSalary(int salary, int increment) {
        this.salary = salary;
        this.increment = increment;

        salary += (salary * increment) / 100;
        return salary;
    }
}
