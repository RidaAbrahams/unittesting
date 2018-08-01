package za.co.rssa.functionalinterfaces;

import za.co.rssa.lambdas.bookexample.firstexample.Employee;

import java.util.Comparator;

public class FunctionExample {

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
     * The Function FI represents an object transformer, from one type to another.
     * Used mostly in 'map' operations in streams and used with Comparator, as key extractors
     */
    public static void main(String[] args) {

        Comparator<Employee> byName = Comparator.comparing(employee -> employee.getName());
    }
}
