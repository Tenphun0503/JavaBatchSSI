package hw2.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceSample {
    static class A {
        static String getMethod(){
            return "A.getMethod";
        }
    }
    static class B {
        static String getMethod(){
            return "B.getMethod";
        }
    }

    public static String runSameTime(){
        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<String> futureA = service.submit(A::getMethod);
        Future<String> futureB = service.submit(B::getMethod);
        try {
            String resultA = futureA.get();
            String resultB = futureB.get();

            return resultB + " " + resultA;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            service.shutdown();
        }
    }

    public static void main(String[] args) {
        System.out.println(runSameTime());
    }
}
