package com.diegoromoli.java8.exercises.chapter01;

import static com.diegoromoli.java8.exercises.chapter01.Exercise6b.RunnableEx.uncheck;

public class Exercise6b {

    interface RunnableEx  {
        void run() throws Exception;

        public static Runnable uncheck(RunnableEx runner) {
            return () -> {
            try {
                runner.run();
            } catch (Exception e) {
                throw new RuntimeException("Exception in thread", e);
            }};
        }
    }

    public static void main(String[] args) {
        Exercise6b e6b = new Exercise6b();
        e6b.go();
    }

    private void go() {
        Thread t = new Thread(uncheck(() -> {
            for(int i=0; i<10; i++) {
                System.out.println(i);
                Thread.sleep(100);
        }} ));
        t.start();
    }

}
