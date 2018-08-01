package za.co.rssa.lambdas.bookexample.workexample;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CMAExample {

    public static void main(String[] args) {
        Set<String> allBanks = Stream.of("SBICZAZAJJ", "SBICZAZAJJ", "SBICZAZAJJ", "SBICNMNMJJ", "SBICNMNMJJ",
                "SBICNMNMJJ", "SBICNMNMJJ", "SBICLSLSJJ", "SBICSWSWJJ")
                .map(s -> s.substring(4, 6))
                .filter(s -> s.equalsIgnoreCase("ZA") || s.equalsIgnoreCase("NM"))
                .collect(Collectors.toSet());

        for (String countryCode : allBanks) {
            System.out.println(countryCode);
        }

    }
}
