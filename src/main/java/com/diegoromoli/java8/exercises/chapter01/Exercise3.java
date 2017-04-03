package com.diegoromoli.java8.exercises.chapter01;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

public class Exercise3 {

    @Test
    public void go() {
        final String extension = ".xml";
        Arrays.stream(doFiltering("/home/diego", extension)).forEach(System.out::println);
    }

    private String[] doFiltering(String dir, String extension) {
        File baseDir = new File(dir);
        // Unlike Exercise 2, the list method of the File class accepts a FilenameFilter (not a FileFilter) and the
        // number of parameters for those two functional interfaces are different
        return baseDir.list((d, name) -> name.endsWith(extension));
    }

}
