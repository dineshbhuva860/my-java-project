package org.example.a1;

import java.time.LocalDate;

public class Employee extends Person implements Payable {
    int employeeId;
    String department;
    double salary;
    Role role;
    LocalDate joinDate;

    public Employee(String name, int age, String gender, int employeeId, String department, double salary, Role role, LocalDate joinDate) {
        super(name, age, gender);
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
        this.role = role;
        this.joinDate = joinDate;
    }

    public double calculateAnnualSalary() {
        return salary * 12;
    }

    public void printDetails() {
        super.printDetails();
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("Role: " + role);
        System.out.println("Join Date: " + joinDate);
        System.out.println("Annual Salary: " + calculateAnnualSalary() + "\n");
    }
}