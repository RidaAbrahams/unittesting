package za.co.rssa.lambdas;

public interface FlyBehaviour {

    void fly();
    default void glide() {
        System.out.println("Glide without implementing it... Weeeeee!!!");
    }
    int NUMBER_OF_WINGS = 2;


}
