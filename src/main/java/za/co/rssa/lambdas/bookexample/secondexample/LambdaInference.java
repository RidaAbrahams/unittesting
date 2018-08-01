package za.co.rssa.lambdas.bookexample.secondexample;

import java.util.function.Consumer;

public class LambdaInference {

    /**
     * Type inference also applies to lambda expressions and plays two roles:
     * 1) It identified which FI is being implemented by a given lambda expression. This is so because the syntax
     *    of the lambda expression does not allow us to specify the FI which is being implemented. The FI is inferred
     *    from the context. The context of a lambda expression must contain enough info to identify the FI being
     *    implemented.
     *    The receiving context for a lambda expression can be specified in the 4 following ways:
     *    a) The lambda expression can be the RHS of an assignment as in:
     *       Consumer<String> = lambda
     *       This is the most common way.
     *    b) The lambda expression can be an actual parameter of a method or constructor as in:
     *       new Thread(lambda)
     *       The compiler infers that we are implementing Runnable since it is the type the Thread constructor
     *       is expecting.
     *    c) The lambda expression can be the argument of a return statement as in:
     *       return lambda
     *       The compiler infers the FI from the return type of the current method.
     *    d) The lambda expression can be the argument of a cast statement as in:
     *       (Consumer<String>) lambda
     * 2) It identifies the parameter types if they are omitted.
     *
     */
    public static void main(String[] args) {
        // Part 1 - Identifying the FI:
        // These examples show what is needed by the compiler to identify the FI.

        // Standard syntax. Compiler can infer the FI and the type parameters.
        // The FI is Consumer since the lambda expression is assigned to a Consumer return variable.
        // The type parameter is String since it is specified in the type of the Consumer.
        Consumer<String> c1 = msg -> System.out.println(msg.length());
        c1.accept("Rida");

        // Compile-time error, Object is not a functional interface.
        // There is not enough info to infer which FI we are trying to implement.
//        Object x1 = msg -> System.out.println(msg.length());

        // Syntax error, The target type Object is not a functional interface.
        // The target type of a lambda expression must be an interface.
        // Even by adding a type for the parameters,
        // there is still not enough info to infer which FI we are trying to implement.
//        Object x2 = (String msg) -> System.out.println(msg.length());

        // A cast can fix the FI inference issue but it is not elegant.
        Object x3 = (Consumer<String>) ((String msg) -> System.out.println(msg.length()));
        ((Consumer) x3).accept("Abrahams");


        // Part 2 - Identifying the parameter types

        // This satisfies the compiler, but note that the inferred parameter type is Object
        Consumer<?> c2 = msg -> System.out.println(msg);

        // Compile-time error: Type inference is not based on the body of the lambda expression.
        // The compiler only infers types based of the context of a lambda expression which appears on the LHS of the
        // assignment. Since this does not tell us what kind of Consumer where are going to build.i.e Consumer<?>
//        Consumer<?> c3 = msg -> System.out.println(msg.length());

        // This type parameter inference problem can easily be solved by explicitly specifying the type for our
        // parameter as in (String msg)
        Consumer<?> c4 = (String msg) -> System.out.println(msg.length());


    }
}
