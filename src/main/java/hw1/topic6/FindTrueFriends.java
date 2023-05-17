package hw1.topic6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindTrueFriends {
    public static void main(String[] args) {
        List<String> names1 = new ArrayList<>();
        List<String> names2 = new ArrayList<>();

        // Adding names to names1
        names1.add("John");
        names1.add("Alice");
        names1.add("Bob");
        names1.add("Eve");

        // Adding names to names2
        names2.add("Bob");
        names2.add("Eve");
        names2.add("Michael");
        names2.add("Alice");

        // Create a Set
        HashSet<String> nameSet = new HashSet<>(names1);
        List<String> trueFriends = new ArrayList<>();
        for(String name: names2){
            if(nameSet.contains(name)) trueFriends.add(name);
        }
        System.out.println(trueFriends);
    }
}
