package com.zopa.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileReader;

class FileUtilsTest {

    @Test
    void readFile() {
        FileReader fileReader = FileUtils.readFile();
        Assertions.assertNotNull(fileReader);
    }
}