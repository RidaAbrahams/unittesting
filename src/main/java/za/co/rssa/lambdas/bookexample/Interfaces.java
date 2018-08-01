package za.co.rssa.lambdas.bookexample;

import za.co.rssa.lambdas.bookexample.firstexample.Employee;

import java.util.Comparator;

public class Interfaces {

    public static void main(String[] args) {
        Employee mike = new Employee("Mike", 2000),
                louise = new Employee("Louise", 2500);

        Comparator<Employee> byName = new Comparator<Employee>() {
            @Override
            public int compare(Employee a, Employee b) {
                return a.getName().compareTo(b.getName());
            }
        };

        System.out.println("By name:");
        System.out.println(byName.compare(mike, louise));
        Comparator<Employee> a = Comparator.nullsLast(byName);
    }
}
