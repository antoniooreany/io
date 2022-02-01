package com.gorshkov.io.buffered;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class BufferedOutputStreamTest {

    private String PATH = "C:/Users/GAS_Dell_XPS9310/IdeaProjects/io/src/test/java/com/gorshkov/io/buffered/fileBOS.txt";
    private BufferedOutputStream outputStream;

    @BeforeEach
    void setUp() throws IOException {
        outputStream = new BufferedOutputStream(new FileOutputStream(PATH));
    }

    @AfterEach
    void tearDown() throws IOException {
        outputStream.close();
    }

    @Test
    void write() throws IOException {
        outputStream.write(5);
        try(InputStream inputStream = new FileInputStream(PATH)) {
            int read = inputStream.read();
            assertEquals(5, read);
        }
    }

    @Test
    void testWrite() {
    }

    @Test
    void testWrite1() {
    }

    @Test
    void flush() {
    }

    @Test
    void close() {
    }
}