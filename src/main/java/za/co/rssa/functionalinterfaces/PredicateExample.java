package za.co.rssa.functionalinterfaces;

import za.co.rssa.lambdas.bookexample.firstexample.Employee;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    /**
     * Summary of functional interfaces
     * ====================================
     * Function Type    | FI Name
     * ------------------------------------
     * nothing -> T     | Supplier
     * T -> nothing     | Consumer
     * T -> T           | UnaryOperator
     * T, T -> T        | BinaryOperator
     * S -> T           | Function
     * T -> boolean     | Predicate
     */

    /**
     * The Predicate represents a property that some objects have.
     * Used mostly with the following method of interface Collection<T>:
     * boolean removeIf(Predicate<T> p)
     * Also used in filter operations in streams
     */
    public static void main(String[] args) {

        Employee joe = new Employee("Joe", 5000, true, false);
        Employee jane = new Employee("Jane", 6000, true, false);
        Employee jack = new Employee("Jack", 7000, true, false);
        Employee john = new Employee("John", 8000, false, false);
        Employee jason = new Employee("Jason", 80000, false, true);
        Employee jackie = new Employee("Jackie", 85000, false, true);

        List<Employee> allEmployees = new ArrayList<>();
        allEmployees.add(joe);
        allEmployees.add(jane);
        allEmployees.add(jack);
        allEmployees.add(john);
        allEmployees.add(jason);
        allEmployees.add(jackie);
        System.out.println("All employees:");
        for (Employee employee : allEmployees) {
            System.out.println(employee.getName());
        }
        System.out.println("Contractors:");
        // Use a predicate to remove employees from the list
        allEmployees.removeIf(e -> e.isPermanent());
        for (Employee employee : allEmployees) {
            System.out.println(employee.getName());
        }
        System.out.println("Under-paid contractors:");
        // Use a predicate to remove employees from the list
        Predicate<Employee> p1 = e -> e.isPermanent();
        Predicate<Employee> p2 = e -> e.isWellPaid();
        allEmployees.removeIf(p1.and(p2));
        for (Employee employee : allEmployees) {
            System.out.println(employee.getName());
        }


    }
}
