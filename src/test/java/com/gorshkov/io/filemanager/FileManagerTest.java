package com.gorshkov.io.filemanager;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileManagerTest {

    private static final String PATH = "C:/Users/GAS_Dell_XPS9310/Dropbox/djinni.co/JavaDev/Luxoft/";

    @org.junit.jupiter.api.Test
    void countFiles() {
        int countFiles = FileManager.countFiles(PATH);
        assertEquals(9, countFiles);
    }

    @org.junit.jupiter.api.Test
    void countDirs() {
        int countDirs = FileManager.countDirs(PATH);
        assertEquals(2, countDirs);
    }

    @org.junit.jupiter.api.Test
    void copy() throws IOException, NotDirectoryPathException {
        String from = "C:/Users/GAS_Dell_XPS9310/IdeaProjects/io/src/test/java/com/gorshkov/io/filemanager/testfolders/1/file1";
        String to = "C:/Users/GAS_Dell_XPS9310/IdeaProjects/io/src/test/java/com/gorshkov/io/filemanager/testfolders/2/file1";

        FileManager.copy(from, to);
    }

    @org.junit.jupiter.api.Test
    void move() {
    }
}