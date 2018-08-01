package za.co.rssa.functionalinterfaces;

import java.util.Arrays;
import java.util.List;

public class BinaryOperatorExample {

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
     * The BinaryOperator represents an operation between 2 objects and it preserves the type.
     * BinaryOperators are used mostly in 'reduce' operations in streams.
     */
    public static void main(String[] args) {

        // This will be shown later when I cover Streams
//        List<String> list1 = Arrays.asList("Rida", "Sameera", "Safiya", "Atheera");
//        list1.replaceAll(s -> s.toUpperCase());
//        for (String name : list1) {
//            System.out.println(name);
//        }
    }
}
