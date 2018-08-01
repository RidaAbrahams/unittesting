package za.co.rssa.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

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
     * The UnaryOperator is an object updater/modifier which preserves the type.
     */
    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("Rida", "Sameera", "Safiya", "Atheera");
        list1.replaceAll(s -> s.toUpperCase());
        for (String name : list1) {
            System.out.println(name);
        }
    }
}
