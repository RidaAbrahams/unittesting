package za.co.rssa.streams.monads;

import java.util.ArrayList;
import java.util.List;

public class Book {

    List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "Book{" +
                "words=" + words +
                '}';
    }
}
