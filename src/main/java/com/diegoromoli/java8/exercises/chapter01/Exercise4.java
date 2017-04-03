package com.diegoromoli.java8.exercises.chapter01;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

public class Exercise4 {

    @Test
    public void go() {
        File[] files = new File("/etc").listFiles();
        Arrays.sort(files, (f1, f2) -> {
            if (f1.isDirectory() && f2.isFile()) {
                return -1;
            } else if (f2.isDirectory() && f1.isFile()) {
                return 1;
            } else return f1.getPath().compareTo(f2.getPath());
        });
        Arrays.stream(files).forEach(System.out::println);
    }

}
