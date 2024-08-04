import java.util.Arrays;

class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add Employee
    public void addEmployee(Employee employee) {
        if (size >= employees.length) {
            resize();
        }
        employees[size++] = employee;
    }

    // Search Employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse Employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete Employee by ID
    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                employees[i] = employees[size - 1]; // Move the last element to the deleted position
                employees[size - 1] = null; // Nullify the last element
                size--;
                return;
            }
        }
    }

    // Resize Array
    private void resize() {
        employees = Arrays.copyOf(employees, employees.length * 2);
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        // Add Employees
        ems.addEmployee(new Employee(1, "John Doe", "Manager", 80000));
        ems.addEmployee(new Employee(2, "Jane Smith", "Developer", 60000));
        ems.addEmployee(new Employee(3, "Emily Davis", "Designer", 50000));

        // Traverse Employees
        System.out.println("All Employees:");
        ems.traverseEmployees();

        // Search Employee
        System.out.println("\nSearch for Employee with ID 2:");
        System.out.println(ems.searchEmployee(2));

        // Delete Employee
        ems.deleteEmployee(2);
        System.out.println("\nAfter Deleting Employee with ID 2:");
        ems.traverseEmployees();
    }
}
