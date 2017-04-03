package com.diegoromoli.java8.first;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertArrayEquals;

/**
 * Hello world!
 */
public class FunctionalInterfacesFirst {

    @Test
    public void firstTest() {
        FunctionalInterfacesFirst fif = new FunctionalInterfacesFirst();
        assertArrayEquals(fif.goComparator(), fif.goLambda());
        assertArrayEquals(fif.goComparator(), fif.goFunction());
    }

    private String[] goFunction() {
        String longString = "longString";
        String shortString = "short";

        String[] arr = {longString, shortString};
        System.out.println("goFunction 1st run:");
        System.out.println("---------------------");
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println();

        Arrays.sort(arr, Comparator.comparing(String::length));

        System.out.println("goFunction 2nd run:");
        System.out.println("---------------------");
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println();
        return arr;

    }


    private String[] goComparator() {
        String longString = "longString";
        String shortString = "short";

        String[] arr = {longString, shortString};
        System.out.println("goComparator 1st run:");
        System.out.println("---------------------");
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println();

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        System.out.println("goComparator 2nd run:");
        System.out.println("---------------------");
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println();
        return arr;
    }

    private String[] goLambda() {
        String longString = "longString";
        String shortString = "short";

        String[] arr = {longString, shortString};
        System.out.println("goLambda 1st run:");
        System.out.println("-----------------");
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println();

        // here the Comaparator interface is replaced with a lambda expression
        // parameter types are inferred (String, String)
        Arrays.sort(arr, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        System.out.println("goLambda 2nd run:");
        System.out.println("-----------------");
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println();
        return arr;
    }
}
