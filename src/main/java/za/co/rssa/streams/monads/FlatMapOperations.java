package za.co.rssa.streams.monads;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlatMapOperations {

    /**
     * The flatMap intermediate method on the Stream interface applies function f to
     * every element in the stream and f returns a new Stream for each element.
     * It then merges all the streams.
     *
     * <R> Stream <R> flatMap(Function<T, Stream<R>> f)
     * @param args
     */
    public static void main(String[] args) {
        List<String> wordsFromABook = Arrays.asList("A", "long", "time", "ago", "in", "a", "galaxy", "far", "far",
                "away", "lived", "a", "monad");
        Book myBook = new Book();
        myBook.setWords(wordsFromABook);
        List<String> words = myBook.getWords();
        for (String word : words) {
            System.out.println(word);
        }

        Set<Book> lib = new HashSet<>();
        lib.add(myBook);
        lib.stream()
                .flatMap(book -> book.getWords()
                .stream())
                .distinct()
                .forEach(System.out::println);
    }

}