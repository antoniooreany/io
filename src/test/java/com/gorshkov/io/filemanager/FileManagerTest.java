package com.gorshkov.io.filemanager;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileManagerTest {

    private static final String PATH_FOR_COUNTING = "./src/test/java/com/gorshkov/io/filemanager/testfolders/counting";

    private static final String SRC_PATH_FOR_COPYING = "./src/test/java/com/gorshkov/io/filemanager/testfolders/copyingandmoving/file1";
    private static final String DST_PATH_FOR_COPYING = "./src/test/java/com/gorshkov/io/filemanager/testfolders/copyingandmoving/dst/file1";

    private static final String SRC_PATH_FOR_MOVING = "./src/test/java/com/gorshkov/io/filemanager/testfolders/copyingandmoving/file2";
    private static final String DST_PATH_FOR_MOVING = "./src/test/java/com/gorshkov/io/filemanager/testfolders/copyingandmoving/dst/file2";

    @org.junit.jupiter.api.Test
    void countFiles() {
        int countFiles = FileManager.countFiles(PATH_FOR_COUNTING);
        assertEquals(6, countFiles);
    }

    @org.junit.jupiter.api.Test
    void countDirs() {
        int countDirs = FileManager.countDirs(PATH_FOR_COUNTING);
        assertEquals(2, countDirs);
    }

    @org.junit.jupiter.api.Test
    void copy() throws IOException, NotDirectoryPathException {
        FileManager.copy(SRC_PATH_FOR_COPYING, DST_PATH_FOR_COPYING);
    }

    @org.junit.jupiter.api.Test
    void move() throws NotDirectoryPathException, IOException {
        FileManager.move(SRC_PATH_FOR_MOVING, DST_PATH_FOR_MOVING);
    }
}
