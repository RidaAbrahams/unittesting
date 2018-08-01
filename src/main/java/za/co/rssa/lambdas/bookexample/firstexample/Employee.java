package za.co.rssa.lambdas.bookexample.firstexample;

public class Employee {

    private String name;
    private int salary;
    private boolean permanent;
    private boolean wellPaid;

    public Employee(String name, int salaray) {
        this.name = name;
        this.salary = salaray;
    }
    public Employee(String name, int salaray, boolean permanent, boolean wellPaid) {
        this.name = name;
        this.salary = salaray;
        this.permanent = permanent;
        this.wellPaid = wellPaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static int getMaxSalary() { return 88000; }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public boolean isWellPaid() {
        return wellPaid;
    }

    public void setWellPaid(boolean wellPaid) {
        this.wellPaid = wellPaid;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
