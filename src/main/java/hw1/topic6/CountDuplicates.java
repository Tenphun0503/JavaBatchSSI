package hw1.topic6;

import java.util.HashMap;
import java.util.Map;

public class CountDuplicates {
    public static void main(String[] args) {

        String str = "Hello World";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if(!Character.isLetter(c)||Character.isWhitespace(c)) continue;

            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()){
            if (e.getValue()>1){
                System.out.println(e.getKey() + " : " + e.getValue());
            }
        }
    }
}
