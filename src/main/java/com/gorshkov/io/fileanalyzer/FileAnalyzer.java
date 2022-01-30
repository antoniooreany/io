package com.gorshkov.io.fileanalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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


    //  duck mcduck. afa afasf duck sfs. safkjlfsdfv sfsdf. adaducksfsf.duck!!
    public static int numberOfMatches(String filePath, String word) throws IOException {
        int count = 0;
        CharSequence charSequence = getStringReadFromFile(filePath);
        Pattern p = Pattern.compile(word);
        Matcher m = p.matcher(charSequence);
        while (m.find()) count++;

        return count;
    }

    //  duck mcduck. afa afasf duck sfs. safkjlfsdfv sfsdf. adaducksfsf.duck!!
    public static void printAllSentencesWithWord(String filePath, String word) throws IOException {
        // TODO Regex: ([^|\\.|?|!].*[duck]+.*[\\.|?|!])
        CharSequence text = getStringReadFromFile(filePath);
        Pattern pattern = Pattern.compile("([^|\\.|?|!].*[" + word + "]+.*[\\.|?|!])");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String substring = text.toString().substring(matcher.start(), matcher.end());
            System.out.println(substring);
        }
    }

    public static void main(String[] args) throws IOException {
//        printAllSentencesWithWord(args[0], args[1]);
//        System.out.println(numberOfMatches(args[0], args[1]));
//        printAllSentencesWithWord(FILE_PATH, "duck");
    }

    private static String getStringReadFromFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
