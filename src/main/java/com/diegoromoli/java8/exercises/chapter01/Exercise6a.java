package com.diegoromoli.java8.exercises.chapter01;

/*
First case: a checked exception inside a Runnable, surrounded with a try/catch. See Exercise6b.
 */
public class Exercise6a {

    public static void main(String[] args) {
        Exercise6a e6a = new Exercise6a();
        e6a.go();
    }

    private void go() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }

}
