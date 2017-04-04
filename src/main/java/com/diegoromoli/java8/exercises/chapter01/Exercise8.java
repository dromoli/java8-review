package com.diegoromoli.java8.exercises.chapter01;

import java.util.ArrayList;
import java.util.List;

public class Exercise8 {

    public static void main(String[] args) {
        doEnhanced();
        doTraditional();
    }
    private static void doEnhanced() {
        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList<>();
        for(String name : names)
            runners.add(() -> System.out.println("Enhanced: " + name));

        for(Runnable runner : runners)
            new Thread(runner).start();
    }

    /*
    This version with the traditional for loop does not allow the usage of the variable i in the lambda,
    as the variable i is not final.
     */

    private static void doTraditional() {
        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList<>();
        for(int i=0; i<names.length; i++) {
            String name = names[i];
            runners.add(() -> System.out.println("Traditional: " + name));
    }

        for(Runnable runner : runners)
            runner.run();
    }


}
