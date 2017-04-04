package com.diegoromoli.java8.exercises.chapter01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Exercise9 {

    interface Collection2<T> extends Collection<T> {

        default void forEachIf(Consumer<T> action, Predicate<T> filter) {
            forEach(t -> {
                if (filter.test(t)) {
                    action.accept(t);
                }
            });
        }
    }

    class MyList<T> extends ArrayList<T> implements Collection2<T> {
    }

    public static void main(String[] args) {
        Exercise9 ex9 = new Exercise9();
        ex9.go();
    }

    private void go() {
        MyList<String> myList = new MyList();
        myList.add("Peter");
        myList.add("Paul");
        myList.add("Mary");
        myList.add("Steve");
        myList.forEachIf((System.out::println), t -> t.length() > 4);

    }

}
