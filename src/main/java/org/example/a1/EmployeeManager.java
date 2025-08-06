package org.example.a1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

enum Role {
    ADMIN, MANAGER, STAFF
}

public class EmployeeManager {
    public static void main(String[] args) {
        // 1. Create a list of employees
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, "Female", 101, "HR", 60000, Role.MANAGER, LocalDate.of(2020, 5, 15)));
        employees.add(new Employee("Bob", 25, "Male", 102, "IT", 45000, Role.STAFF, LocalDate.of(2022, 1, 10)));
        employees.add(new Employee("Charlie", 45, "Male", 103, "IT", 80000, Role.ADMIN, LocalDate.of(2018, 9, 21)));
        employees.add(new Employee("Diana", 35, "Female", 104, "HR", 55000, Role.STAFF, LocalDate.of(2021, 3, 5)));
        employees.add(new Employee("Eve", 28, "Female", 105, "Sales", 95000, Role.MANAGER, LocalDate.of(2019, 11, 2)));

        System.out.println(" All Employee Details: \n");
        for (Employee emp : employees) {
            emp.printDetails();
        }

        System.out.println("\n Employees with Salary > 50,000: \n");
        for (Employee emp : employees) {
            if (emp.salary > 50000) {
                emp.printDetails();
            }
        }

        // 4. Group employees by department and count them
        System.out.println("\n Employee Count by Department \n");
        Map<String, Long> departmentCounts = employees.stream().collect(Collectors.groupingBy(e -> e.department, Collectors.counting()));
        for (Map.Entry<String, Long> entry : departmentCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 5. Sort employees by join date
        System.out.println("\n Employees Sorted by Join Date: \n");
        employees.sort(Comparator.comparing(e -> e.joinDate));
        for (Employee emp : employees) {
            System.out.println(emp.name + " joined on " + emp.joinDate);
        }

        // 6. Print employee names using method reference
        System.out.println("\n Employee Names using Method Reference \n");
        employees.stream().map(e -> e.name).forEach(System.out::println);

        // 7. Find the highest paid employee
        System.out.println("\n Highest Paid Employee \n");
        Optional<Employee> highestPaidEmployee = employees.stream().max(Comparator.comparingDouble(e -> e.salary));
        if (highestPaidEmployee.isPresent()) {
            System.out.println("Highest Paid Employee Details: \n");
            highestPaidEmployee.get().printDetails();
        } else {
            System.out.println("No employees found.");
        }
    }
}