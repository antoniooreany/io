package com.gorshkov.io.fileanalyzer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Используем классы FileInputStream, FileOutputStream, File
//        Практика:
//        1: Написать программу FileAnalyzer, которая в консоли принимает 2 параметра:
//        1) путь к файлу
//        2) слово
//        Usage:
//        java FileAnalyzer C:/test/story.txt duck
//
//        Выводит:
//        1) Кол-во вхождений искомого слова в файле
//        2) Все предложения содержащие искомое слово(предложение заканчивается символами ".", "?", "!").
//        Каждое предложение выводится с новой строки.

public class FileAnalyzer {

    private static final int BUFFER_SIZE = 1024;

    //  duck mcduck. afa afasf duck sfs. safkjlfsdfv sfsdf. adaducksfsf.duck!!
    public static int numberOfMatches(String filePath, String word) throws IOException {
        int count = 0;
        CharSequence charSequence = getStringReadFromFile(filePath);
        Pattern pattern = Pattern.compile(word);
        Matcher matcher = pattern.matcher(charSequence);
        while (matcher.find()) count++;

        return count;
    }

    //  duck mcduck. afa afasf duck sfs. safkjlfsdfv sfsdf. adaducksfsf.duck!!
    public static void printAllSentencesWithWord(String filePath, String word) throws IOException {
        // TODO Regex: ([^\\.?!].*\bduck\b.*[\\.?!])
        CharSequence text = getStringReadFromFile(filePath);
//        Pattern pattern = Pattern.compile("([^|\\.|?|!].*[" + word + "]+.*[\\.|?|!])");
//        Pattern pattern = Pattern.compile(".*([\\.?!].*\b" + word + "\b.*[\\.?!]).*");
//        Pattern pattern = Pattern.compile(".*(\b" + word + "\b).*");
//        Pattern pattern = Pattern.compile(".*(.*" + word + ".*).*");
        Pattern pattern = Pattern.compile("" + word + "");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String substring = text.toString().substring(matcher.start(), matcher.end()); //TODO Correct this.
            System.out.println(substring);

        }
    }

//    C:\Users\GAS_Dell_XPS9310\.jdks\openjdk-17.0.2\bin\java.exe -classpath C:\Users\GAS_Dell_XPS9310\IdeaProje
//    at com.gorshkov.io.fileanalyzer.FileAnC:\Users\GAS_Dell_XPS9310\.jdks\openjdk-17.0.2\bin\java.exe -classpath C:\Users\GAS_Dell_XPS9310\IdeaProje
//    cts\io\target\classes com.gorshkov.io.fileanalyzer.FileAnalyzer C:\Users\GAS_Dell_XPS9310\IdeaProjects\io\src\test\java\com\gorshkov\io\fileanalyzer\sto
//    ry.txt duck

    public static void main(String[] args) throws IOException {
        printAllSentencesWithWord(args[0], args[1]);
        System.out.println(numberOfMatches(args[0], args[1]));
//        printAllSentencesWithWord(FILE_PATH, "duck");
    }

    private static String getStringReadFromFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    private static String getStringReadFromFileUsingStream(String fileName) throws IOException {
        ArrayList<String> arrayListBuffer;
        try (InputStream inputStream = new FileInputStream(fileName); OutputStream outputStream = new ByteArrayOutputStream()) {
            arrayListBuffer = new ArrayList();
            byte[] buffer = new byte[BUFFER_SIZE];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        }
        return arrayListBuffer.toString();
    }
}
