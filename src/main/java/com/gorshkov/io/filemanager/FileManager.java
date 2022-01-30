package com.gorshkov.io.filemanager;

import java.io.*;

//2: Пишем class FileManager с методами
//public class FileManager {
// public static int countFiles(String path) - принимает путь к папке,
// возвращает количество файлов в папке и всех подпапках по пути

// public static int countDirs(String path) - принимает путь к папке,
// возвращает количество папок в папке и всех подпапках по пути

//    public static void copy(String from, String to) - метод по копированию папок и файлов.
//    Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование.
//    public static void move(String from, String to) - метод по перемещению папок и файлов.
//    Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование.

public class FileManager {

    private static final int BUFFER_SIZE = 1024;

    public static int countFiles(String path) {
        int count = 0;
        File folder = new File(path);
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                count += countFiles(entry.getAbsolutePath());
            } else {
                count++;
            }
        }
        return count;
    }

    public static int countDirs(String path) {
        int count = 0;
        File folder = new File(path);
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                count += countDirs(entry.getAbsolutePath());
                count++;
            }
        }
        return count;
    }

    public static void copy(String from, String to) throws IOException, NotDirectoryPathException {
        File fileTo = new File(to);
        if (fileTo.isFile()) {
            throw new NotDirectoryPathException("The destination path '" + to + "' is not a directory name.");
        }
        File fileFrom = new File(from);
        if (fileFrom.isDirectory()) {
            for (File file : fileFrom.listFiles()) {
                copy(file.getAbsolutePath(), to); //TODO not 'to', but 'to\...'
            }
        } else copyFile(fileFrom.getAbsolutePath(), to);
    }

    public static void move(String from, String to) throws IOException, NotDirectoryPathException {
        copy(from, to);
        File file = new File(from);
        boolean deleted = file.delete();
    }

    private static void copyFile(String from, String to) throws IOException {
        try (InputStream is = new FileInputStream(from); OutputStream os = new FileOutputStream(to)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }
}
