package za.co.rssa.methodreferences;

import za.co.rssa.lambdas.bookexample.firstexample.Employee;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class MethodRefs {

    // Customer written FI
    interface ThreadSupplier {
        Thread giveMeAThread();
    }

    /**
     * Method references should be used instead of using the Method class
     * in java reflection. Method refs are less complicated and easier to use.
     * Method refs are characterized by the double colon, i.e. ::
     *
     */

    public static void main(String[] args) {

        // Static method
        Supplier<Thread> s1 = Thread::currentThread;
        Thread thread = s1.get();

        // another e.g. of a static method
        IntSupplier maxSalary = Employee::getMaxSalary;
        System.out.println(maxSalary.getAsInt());

        // The code below shows that method refs have no type.
        // The type is deduced via type inference, as is the case below.
        // There is nothing special about the Supplier FI since it can be swapped
        // out for a custom written FI. The compiler will deduce the type based
        // on the context in which this method ref is used. So the same method ref
        // can be assigned to different types as is the case here.
        ThreadSupplier threadSupplier = Thread::currentThread;
        Thread thread1 = threadSupplier.giveMeAThread();

        // Instance method
        Employee frank = new Employee("Frank", 3000);
        // The normal way of doing this
        Integer salary = frank.getSalary();
        System.out.println(salary);

        // The functional way using method refs
        Supplier<Integer> s2 = frank::getSalary;
        System.out.println(s2.get());

        // A common instance method (instance specified)
        // This works bcoz println is a method that accepts a sting and returns void
        Consumer<String> c1 = System.out::println;
        c1.accept("Hello method references");
        c1.accept("Good bye imperative programming");

        // A method ref to an instance method where the instance is not specified
        // In this case you need to assign this method ref to a Function that
        // accepts an Employee instance(N.B. it has to be an instance) and returns an Integer.
        // This allows you to split instances from their methods.
        Function<Employee, Integer> f1 = Employee::getSalary;
        Integer frankSalary = f1.apply(frank);
        System.out.println(frankSalary);

        // A useful application: building a comparator based on a field
        // comparing expects Function<Employee, U>,
        // where U supports natural ordering (i.e. Comarable)

        Comparator<Employee> byName = Comparator.comparing(Employee::getName);

        main2();
    }

    public static <T> void printAll(T[] array, Function<T, String> toStringFun) {
        int i = 0;
        for (T t : array) {
            System.out.println(i++ + ":\t" + toStringFun.apply(t));
        }
    }

    public static void main2() {
        Employee[] dept = new Employee[5];
        dept[0] = new Employee("Alec", 1500);
        dept[1] = new Employee("Bob", 1600);
        dept[2] = new Employee("Claire", 1700);
        dept[3] = new Employee("Danielle", 1800);
        dept[4] = new Employee("Ethan", 1900);
        printAll(dept, Employee::getName);

        System.out.println("");

        // Compile-time error : type inference failure. the printAll method
        // does not accept and Function with an Integer as a parameter only a
        // Function that has a String as a parameter
//        printAll(dept, Employee::getSalary);
        // We fix this by concatenating the salary with a String
        printAll(dept, emp -> "" + emp.getSalary());
    }
}
