package com.gorshkov.io.buffered;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BufferedInputStreamTest {

    private String PATH = "C:/Users/GAS_Dell_XPS9310/IdeaProjects/io/src/test/java/com/gorshkov/io/buffered/fileBIS.txt";
//    private BufferedInputStream inputStream;

    @BeforeEach
    void setUp() throws IOException {

    }

    @Test
    void read() throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(PATH));
        int read = inputStream.read();
        assertEquals('s', (char)read);
    }

    @Test
    void testReadToArray() throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(PATH));
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        assertEquals(20, read);
    }

    @Test
    void testReadToArrayWithOffset() {
    }

    @Test
    void close() {
    }
}