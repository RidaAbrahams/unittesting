package za.co.rssa.streams.creating;

import za.co.rssa.lambdas.bookexample.firstexample.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamCreation {
    /**
     * Streams can be created in 3 ways:
     * 1) From a static sequence of objects
     * 2) From Arrays and Collections
     * 3) From Computations, i.e. Dynamically generating every object on the fly.
     *    There are 2 ways to do this:
     *    a) Generate each element in the sequence seperately via Supplier
     *    b) Generate each element in the sequence from the previous sequence via UnaryOperator
     *    N.B. On demand computation is called "lazy evaluation"
     *
     * Elements are created and processed when required by the terminal operation, i.e.
     * elements are pulled from the end not pushed from the start.
     * So all intermediate operations will not be evaluated until a terminal operation
     * is executed.
     *
     * Very important: Streams can only be traversed ONCE!!!
     */

    public static void main(String[] args) {

        // Create Streams from a static sequence of objects
        createStreamsFromStaticSequenceOfObjects();
        createStreamsFromAnArray();
        createStreamsFromACollection();
        createStreamsViaComputation();
        showcaseStreamOnlyBeingTraversedOnce();
    }

    private static void showcaseStreamOnlyBeingTraversedOnce() {
        Stream<Integer> fib = Stream.of(1, 1, 2, 3);
        fib.forEach(System.out::println);
        // This causes an exception, since the stream can only be traversed once, it is closed thereafter
//        fib.forEach(System.out::println);

        System.out.println("");

        Stream<Integer> fib2 = Stream.of(1, 1, 2, 3);
        // This causes an exception, since the stream can only be traversed once, it is closed thereafter.
        // Explaination: the limit() is an intermediate op. Intermediate ops return a new stream.
        // by seperating the ops and not chaining them together, we are not traversing the stream once.
        // when we call the forEach method, we are attempting to traverse an already closed stream. i.e. the old stream
//        fib2.limit(3);
        fib2.forEach(System.out::println);

        System.out.println("");

        // The correct way to do this if we need to split ops
        // This works because you are traversing a new Stream, not the old one.
        Stream<Integer> fib3 = Stream.of(1, 1, 2, 3);
        Stream<Integer> shortFib = fib3.limit(2);
        shortFib.forEach(System.out::println);


    }

    private static void createStreamsViaComputation() {
        // N.B. don't execute this method, since I don't know
        // how to limit the numbers in these infinite streams
        // Gen each element separately
        // Use the static <T> Stream<T> generate(Supplier<T> s) method, which
        // generates an unordered infinite stream
//        Random random = new Random();
//        Stream<Integer> randoms = Stream.generate(random::nextInt);


        // Create each element from the previous element
        // Use the static <T> Stream<T> iterate(T first, UnaryOperator<T> next)
        // which generates an ordered infinite stream
        // Gens a stream of sequences of 'a's
//        Stream<String> as = Stream.iterate("a", s -> s + "a");

        final Random random = new Random();
        Supplier<Integer> supp = () -> {
            Integer result = random.nextInt();
            System.out.println("(supplying " + result + ")");
            return result;
        };

        System.out.println("\n Test 1");

        // Note: Nothing is printed between Test 1 and First stream built. i.e.
        // this proves that the supplier code is not invoked at all when we call generate().
        // Its invocation is delayed until the integers are needed
        Stream<Integer> randoms = Stream.generate(supp);

        System.out.println("First stream built");

        // Note: negative integers will be generated but not included in the stream
        // only 3 Integers are printed since the limit is 3
        randoms.filter(n -> n>=0).limit(3).forEach(System.out::println);

        System.out.println("\n\n\n Test 2");
        // Swap the order of the limit and filter operations around
        // in this case only 3 Integers will ever be generated, the filer happens thereafter
        Stream<Integer> randoms2 = Stream.generate(supp);
        randoms2.limit(3).filter(n -> n>=0).forEach(System.out::println);
    }

    private static void createStreamsFromStaticSequenceOfObjects() {
        // Method signature of Stream.of is: public static<T> Stream<T> of(T... values)

        // Use the static method 'Stream.of' to create a stream of Integers
        Stream<Integer> fib = Stream.of(1, 1, 2, 3);
        fib.forEach(System.out::println);

        System.out.println("");

        // Use the static method 'Stream.of' to create a stream of Strings
        Stream<String> italianNumbers = Stream.of("uno", "due", "tre");
        italianNumbers.forEach(System.out::println);

        System.out.println("");

        // Use the static method 'Stream.of' to create a stream of Employees from an array
        Employee[] emps = new Employee[5];
        emps[0] = new Employee("Alec", 1500);
        emps[1] = new Employee("Bob", 1600);
        emps[2] = new Employee("Claire", 2700);
        emps[3] = new Employee("Danielle", 2800);
        emps[4] = new Employee("Ethan", 2900);
        Stream<Employee> empStream = Stream.of(emps);
        empStream.forEach(System.out::println);
    }

    private static void createStreamsFromAnArray() {
        System.out.println("");
        Employee[] emps = new Employee[5];
        emps[0] = new Employee("Alec", 21500);
        emps[1] = new Employee("Bob", 21600);
        emps[2] = new Employee("Claire", 22700);
        emps[3] = new Employee("Danielle", 22800);
        emps[4] = new Employee("Ethan", 22900);
        Stream<Employee> employeeStream = Arrays.stream(emps);
        employeeStream.forEach(System.out::println);
    }

    private static void createStreamsFromACollection() {
        System.out.println("");
        Employee[] emps = new Employee[5];
        emps[0] = new Employee("Alec", 31500);
        emps[1] = new Employee("Bob", 31600);
        emps[2] = new Employee("Claire", 32700);
        emps[3] = new Employee("Danielle", 32800);
        emps[4] = new Employee("Ethan", 32900);
        // First create the collection
        List<Employee> list = Arrays.asList(emps);
        Stream<Employee> employeeStream = list.stream();
        Stream<Employee> employeePStream = list.parallelStream();
    }
}
