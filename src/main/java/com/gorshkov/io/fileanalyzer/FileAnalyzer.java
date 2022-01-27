package com.gorshkov.io.fileanalyzer;

import java.io.FileReader;
import java.io.IOException;
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

    public int numberOfMatches(String filePath, String word) throws IOException {

        int count = 0;

        FileReader reader = new FileReader(filePath);

        Pattern p = Pattern.compile("\\b" + word + "\\b", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);
        while (m.find()) count++;

        reader.close();
        return count;
    }

    public String allSentencesWithWord(String filePath, String word) {
        String result = "";


        return result;
    }


    public static void main(String[] args) {
        String filePath = "C:/Users/GAS_Dell_XPS9310/IdeaProjects/io/src/test/java/com/gorshkov/io/fileanalyzer/";

    }
}
