package com.gorshkov.io.filemanager;

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

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

//C:\Users\GAS_Dell_XPS9310\Dropbox\djinni.co\JavaDev\Luxoft
public class FileManager {
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
            throw new NotDirectoryPathException("The destination path '" + to + "' is not directory name.");
        }
        File fileFrom = new File(from);
        if (fileFrom.isDirectory()) {
            for (File file : fileFrom.listFiles()) {
                copy(file.getAbsolutePath(), to); //TODO not 'to', but 'to\...'
            }
        } else copyOneFile(fileFrom.getAbsolutePath(), to);
    }

    public static void move(String from, String to) throws IOException, NotDirectoryPathException {
        File folder = new File(from);

        File[] listOfFiles = folder.listFiles();

        Path destDir = Paths.get(to);
        if (! new File(to).isDirectory()) {
            throw new NotDirectoryPathException("The destination path '" + to + "' is not directory name.");
        }
        if (listOfFiles != null)
            for (File file : listOfFiles)
                Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
    }


    private static void copyOneFile(String from, String to) throws IOException {
        try (InputStream is = new FileInputStream(from); OutputStream os = new FileOutputStream(to)) {
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }
}
