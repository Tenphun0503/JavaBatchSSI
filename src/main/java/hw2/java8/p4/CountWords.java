package hw2.java8.p4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountWords {
    public static void main(String[] args) {
        String s = "Eclipse eclipse Eclipse eclipse amc clip ECLIPSE";
        Map<String, Long> map = Arrays.stream(s.split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ));
        System.out.println(map);
    }
}
