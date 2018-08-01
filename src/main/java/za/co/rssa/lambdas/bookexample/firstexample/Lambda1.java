package za.co.rssa.lambdas.bookexample.firstexample;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * This is your one-stop shop for learning lambda expression syntax.
 * A lambda expression has the following basic syntax:
 * parameters -> body
 *
 * parameters can take of the following form:
 * (int a, int b) i.e. parameters with their type
 * (a, b)         i.e. parameters without their type
 * (a)            i.e. a single parameter without it's type
 * ()             i.e. no parameters
 * a              i.e. a single parameter, and hence no parenthesis required
 *
 * body can take on the following form:
 * { block of code}
 * single expression
 */

public class Lambda1 {

    public static void main(String[] args) {

        /*
         * All these examples do exactly the same this, they are
         * just different ways of implementing a functional interface
         */

        Employee mike = new Employee("Mike", 2000),
                louise = new Employee("Louise", 2500);

        // Implementing a Comparator the old fashioned way with annonymous inner classes
        // There is alot of boilerplate code here:
        // the new keyword,
        // the interface name even though the assignment variable on the left has the
        // interface name already(i.e. Compare<Employee>),
        // the compare method name is repeated even though the FI already
        // defined the compare method,
        // the full body of the compare method is defined, i.e. we have to
        // write down the full abstract method of the interface method we're
        // implementing. i.e. the compare method.
        // What alot of typing!!!
        Comparator<Employee> byName = new Comparator<Employee>() {
            @Override
            public int compare(Employee a, Employee b) {
                return a.getName().compareTo(b.getName());
            }
        };

        System.out.println("1st e.g. results = " + byName.compare(mike, louise));

        // Our first lambda expression.
        // Benefits:
        // no new keyword,
        // the interface name is not repeated,
        // the name of the abstract method that we're implemented is not repeated.
        // We only define the parameter list: (Employee a, Employee b)
        // the body of the implementation of the abstract method: return a.getName().compareTo(b.getName());
        // this can only work for FIs, since there is only 1 abstract method and no ambiguous way of interpreting
        // an abstract method. i.e. there is only the compare method in the Comparator interface.
        // That is why you don't have to specify the name of the abstract method you're implementing, coz there
        // is only one anyway and it is defined in the interface for which you're providing an implementation for.
        Comparator<Employee> byNameLambda1 =
                (Employee a, Employee b) -> { return a.getName().compareTo(b.getName()); };

        // This version is more concise as it removes the types from the parameter list.
        // This is possible because the compiler can infer the type "Employee" based on the fact that you're
        // assigning this lambda expression to a Comparator<Employee>
        Comparator<Employee> byNameLambda2 =
                (a, b) -> { return a.getName().compareTo(b.getName());};

        // This version is super concise as it removes the return keyword and the curly braces.
        // It is possible to remove the return statement and curly braces because the body of the lambda expression
        // contains a single statement which is a return statement.
        // Lambdas get there name from the fact that there body can be a single expression that is automatically returned
        // NB!!! the ';' is not needed after the expression "a.getName().compareTo(b.getName()" as it is the only statement
        Comparator<Employee> byNameLambda3 = (a, b) -> a.getName().compareTo(b.getName());

        // You cannot remove the braces and leave the 'return' keyword as this results in a compile time error.
//        Comparator<Employee> byNameLambda4 =
//                (a, b) -> return a.getName().compareTo(b.getName());

        // Lambda with no parameters
        // Just provide the parenthesis with no parameters
        Runnable r = () -> {System.out.println("Compact Runnable!");};
        Thread t1 = new Thread(r);
        t1.run();

        // You don't have to mention Runnable if you inline the method
        Thread t2 = new Thread(() -> {System.out.println("An implicit Runnable!");});
        t2.run();

        // Braces and return keyword can be removed as there is only one statement
        // NB!!! the ';' is not needed after the expression "System.out.println("Another implicit Runnable")" as it is the only statement
        Thread t3 = new Thread(() -> System.out.println("Another implicit Runnable"));

        // When an FI has a single parameter the parenthesis can be removed, i.e. type 's' instead of '(s)'
        // FYI: Consumer has a single abstract method called accept()
        Consumer<String > lengthPrinter = s -> System.out.println(s.length());
        lengthPrinter.accept("Rida");
    }
}
