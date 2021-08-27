package com.zopa.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;

public class FileUtils {

    public static FileReader readFile() {
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            return new FileReader(Objects.requireNonNull(classloader.getResource("marketData.csv")).getFile());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
            return null;
        }
    }
}
