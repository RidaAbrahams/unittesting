package za.co.rssa.streams.introduction;

import za.co.rssa.lambdas.bookexample.firstexample.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IntroToStreams {

    public static void main(String[] args) {
        // Iterate using a list and a for each loop
        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5 );
        for (Integer n : l) {
            System.out.println(n);
        }

        System.out.println("");

        // Iterate using an Iterator
        List<Integer> l2 = Arrays.asList(1, 2, 3, 4, 5 );
        Iterator<Integer> i = l2.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        System.out.println("");

        List<Integer> l3 = Arrays.asList(1, 2, 3, 4, 5 );
        Stream<List<Integer>> s = Stream.of(l3);
        s.forEach(System.out::println);

        /**
         * A Simple example to get started.
         * Print the names of the employees with a salary of at least 2500, alphabetically sorted.
         */
        Employee[] emps = new Employee[5];
        emps[0] = new Employee("Alec", 1500);
        emps[1] = new Employee("Bob", 1600);
        emps[2] = new Employee("Claire", 2700);
        emps[3] = new Employee("Danielle", 2800);
        emps[4] = new Employee("Ethan", 2900);

        Arrays.stream(emps).filter(e -> e.getSalary() >= 2500)
                .map(Employee::getName)
                .sorted()
                .forEach(System.out::println);


    }
}
