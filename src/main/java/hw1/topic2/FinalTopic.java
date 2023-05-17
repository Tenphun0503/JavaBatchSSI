package hw1.topic2;

import java.util.ArrayList;

// Final Classes cannot be inherited
public final class FinalTopic {

    // Final variables must be initialized either during declaration or within the constructor.
    // Final variables cannot be modified once assigned.
    private static final ArrayList<Integer> VAR = new ArrayList<>();

    // Final methods cannot be overridden in th subclasses
    private static final void method(){
        VAR.add(1);
        VAR.add(2);
    }

    public static void main(String[] args) {
        method();
        System.out.println(VAR);
    }
}
