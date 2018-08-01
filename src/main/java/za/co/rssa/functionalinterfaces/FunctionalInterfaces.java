package za.co.rssa.functionalinterfaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;

public class FunctionalInterfaces {

    public static void main(String[] args) {

        // Runnable examples
        // Thread running the imperative way
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running the imperative way...");
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();

        // Thread running the functional way
        Runnable r2 = () -> System.out.println("Running the functional way...");
        Thread t2 = new Thread(r2);
        t2.start();

        // Callable examples
        // Callable cannot be run directly with the Thread class, use ExecutorService instead.
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Thread running the imperative way
        Callable<String> c1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Callable executed the imperative way...");
                return "The call was successful";
            }
        };
        Future<String> future = executorService.submit(c1);
        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Thread running the functional way
        Callable<String> c2 = () -> {
            System.out.println("Callable executed the functional way...");
            return "The call was successful...";
        };
        Future<String> future2 = executorService.submit(c2);
        try {
            System.out.println(future2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Comparator with no lambdas
        // The Collections.sort method requires a List, create it here
        List<String> names = Arrays.asList("Rida", "Sameera", "Safiya", "Atheera");

        Comparator<String> comparator1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        Collections.sort(names, comparator1);
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("");

        // Comparator with lambdas
        List<String> names2 = Arrays.asList("Rida", "Sameera", "Safiya", "Atheera");
        Collections.sort(names2, (s1, s2) -> s1.compareTo(s2));
        for (String name : names2) {
            System.out.println(name);
        }

        System.out.println("");

        // Even more concise with method refs
        List<String> names3 = Arrays.asList("Rida", "Sameera", "Safiya", "Atheera");
        Collections.sort(names3, String::compareTo);
        for (String name : names3) {
            System.out.println(name);
        }

    }
}
