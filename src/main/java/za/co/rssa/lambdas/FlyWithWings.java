package za.co.rssa.lambdas;

public class FlyWithWings implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Flying with " + NUMBER_OF_WINGS + " wings");
    }
}
