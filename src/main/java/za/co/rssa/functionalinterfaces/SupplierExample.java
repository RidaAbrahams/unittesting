package za.co.rssa.functionalinterfaces;

import java.time.LocalTime;
import java.util.Objects;

public class SupplierExample {

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

    public static void main(String[] args) {
        // Supplier example
        // the getApplicationStatus() is called 4 times is this case
        // since it has to create 4 Strings
        System.out.println("called without a lambda");
//        System.out.println(composeHashcodes("Hello", "world"));
//        System.out.println(composeHashcodes("Hello", null));
        System.out.println("called using a lambda");

        // the getApplicationStatus() is called once is this case.
        // This is so because the invocation of getApplicationStatus was delayed
        // until it was actually needed, which was when the 2nd arg to composeHashcodes2 was null
        System.out.println(composeHashcodes2("Hello", "world"));
        System.out.println(composeHashcodes2("Hello", null));
    }

    public static int composeHashcodes(Object a, Object b) {
        Objects.requireNonNull(a, "a may not be null " + getApplicationStatus());
        Objects.requireNonNull(b, "b may not be null " + getApplicationStatus());
        return a.hashCode() ^ b.hashCode();
    }

    // The second arg to Objects.requireNonNull now takes a Supplier<String> instead of String
    //
    public static int composeHashcodes2(Object a, Object b) {
        Objects.requireNonNull(a, () ->"a may not be null " + getApplicationStatus());
        Objects.requireNonNull(b, () ->"b may not be null " + getApplicationStatus());
        return a.hashCode() ^ b.hashCode();
    }

    // Pretend that this is a slow method
    private static String getApplicationStatus() {
        System.out.println("getApplicationStatus");
        return "It's " + LocalTime.now();
    }
}
