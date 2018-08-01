package za.co.rssa.streams.monads;

import java.util.Random;
import java.util.stream.Stream;

public class StreamFilters {

    /**
     * Filter operations are intermediate operations that selecte some elements and
     * discard others based on:
     * a) Content - the operations that do this are: filter, takeWhile, dropWhile
     * b) Amount - the operations that do this are: limit
     * c) Uniqueness - the operations that do this are: distinct
     */
    public static void main(String[] args) {
        // select 10 random positive distinct integers
        final Random rand = new Random();
        Stream<Integer> randoms = Stream.generate(rand::nextInt);
        randoms.filter(n -> n > 0).distinct().limit(10).forEach(System.out::println);
    }
}
