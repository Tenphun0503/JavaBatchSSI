package hw2.java8.p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyStream<T, R> {

    @FunctionalInterface
    interface MyFunction<T, R> {
        R apply(T t);
    }
    static <T, R> List<R> myMap(List<T> list, MyFunction<T, R> function) {
        List<R> res = new ArrayList<>();
        for(T t : list){
            res.add(function.apply(t));
        }
        return res;
    }

    static List<Integer> myMap2(List<Integer> list, MyFunction<Integer, Integer> function) {
        List<Integer> res = new ArrayList<>();
        for(Integer i : list){
            res.add(function.apply(i));
        }
        return res;
    }

    // way 1, implements interface
    static class MyClass implements MyFunction<Integer,Integer>{
        @Override
        public Integer apply(Integer integer) {
            return integer * 3;
        }
    }

    public static void main(String[] args) {
        // way 1, continue
        MyClass myClass = new MyClass();
        System.out.println(myClass.apply(3));

        // way 2, implements with construction
        MyFunction<Integer, Integer> myFunction = new MyFunction<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * 3;
            }
        };
        System.out.println(myFunction.apply(3));

        // way 3, implements with lambda
        MyFunction<Integer, Integer> myLambda = o -> o*3;
        System.out.println(myLambda.apply(3));
    }
}

class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println(MyStream.myMap(numbers, o -> o*3));
    }
}



