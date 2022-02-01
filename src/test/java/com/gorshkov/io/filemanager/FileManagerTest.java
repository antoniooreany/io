package com.gorshkov.io.filemanager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileManagerTest {

    private static final String PATH_FOR_COUNTING = "./src/test/java/com/gorshkov/io/filemanager/testfolders/counting";

    private static final String SRC_PATH_FOR_COPYING = "./src/test/java/com/gorshkov/io/filemanager/testfolders/copyingandmoving/src/file1";
    private static final String DST_PATH_FOR_COPYING = "./src/test/java/com/gorshkov/io/filemanager/testfolders/copyingandmoving/dst/file1";

    private static final String SRC_PATH_FOR_MOVING = "./src/test/java/com/gorshkov/io/filemanager/testfolders/copyingandmoving/src/file2";
    private static final String DST_PATH_FOR_MOVING = "./src/test/java/com/gorshkov/io/filemanager/testfolders/copyingandmoving/dst/file2";
    private File fileSrcForCopying;
    private File fileDstForMoving;

    @BeforeEach
    void init() throws IOException {
        fileSrcForCopying = new File(SRC_PATH_FOR_COPYING);
        fileDstForMoving = new File(SRC_PATH_FOR_MOVING);
        fileSrcForCopying.createNewFile();
        fileDstForMoving.createNewFile();
    }

    @AfterEach
    void finalise() {
        fileSrcForCopying.delete();
        fileDstForMoving.delete();
        File fileDstForCopying = new File(DST_PATH_FOR_COPYING);
        File fileDstForMoving = new File(DST_PATH_FOR_MOVING);
        fileDstForCopying.delete();
        fileDstForMoving.delete();
    }

    @Test
    void countFiles() {
        int countFiles = FileManager.countFiles(PATH_FOR_COUNTING);
        assertEquals(6, countFiles);
    }

    @Test
    void countDirs() {
        int countDirs = FileManager.countDirs(PATH_FOR_COUNTING);
        assertEquals(2, countDirs);
    }

    @Test
    void copy() throws IOException, NotDirectoryPathException {
        FileManager.copy(SRC_PATH_FOR_COPYING, DST_PATH_FOR_COPYING);
    }

    @Test
    void move() throws NotDirectoryPathException, IOException {
        FileManager.move(SRC_PATH_FOR_MOVING, DST_PATH_FOR_MOVING);
    }
}
