package za.co.rssa.lambdas.bookexample.secondexample;

public class TypeInference {

    /**
     * Type inference is where the compiler fills in a missing type
     * that has not been specified. The compiler infers the type
     * by looking at what the type is that is being passed to the method.
     * In this example the type will be String.
     */
    public static void main(String[] args) {
        String[] strarray = {"one", "two", "three"};
        String one = getFirst(strarray);
        System.out.println(one);
    }

    private static <T>T getFirst(T[] array) {
        return array[0];
    }
}
