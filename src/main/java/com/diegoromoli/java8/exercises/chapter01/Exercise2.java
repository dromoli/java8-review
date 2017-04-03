package com.diegoromoli.java8.exercises.chapter01;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

public class Exercise2 {

    File baseDir;

    @Before
    public void setUp() throws Exception {
        baseDir = new File("/home/diego/");
    }

    @Test
    public void listDirectories() {
        File[] subDirectories = baseDir.listFiles(dir -> dir.isDirectory());
        Arrays.stream(subDirectories).forEach(  System.out::println);
    }

    @Test
    public void listDirectoriesMethodReference() {
        // Here the lambda expression is replaced with a method reference
        File[] subDirectories = baseDir.listFiles(File::isDirectory);
        Arrays.stream(subDirectories).forEach(  System.out::println);
    }

}
