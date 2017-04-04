package com.diegoromoli.java8.exercises.chapter01;

public class Exercise7 {

    public static Runnable andThen(Runnable first, Runnable second) {
        return () -> {
            first.run();
            second.run();
        };
    }

    public static void main(String[] args) {
        Runnable r = andThen(() -> {
            for(int i=0; i<10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }, () -> {
            for(int i=10; i>0; i--) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        });
        new Thread(r).start();
    }

}
