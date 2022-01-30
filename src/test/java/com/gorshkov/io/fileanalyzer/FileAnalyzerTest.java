package com.gorshkov.io.fileanalyzer;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileAnalyzerTest {

    private static final String FILE_PATH = "C:/Users/GAS_Dell_XPS9310/IdeaProjects/io/src/test/java/com/gorshkov/io/fileanalyzer/story.txt";

    @Test
    void numberOfMatches() throws IOException {
//        String filePath = "C:/Users/GAS_Dell_XPS9310/IdeaProjects/io/src/test/java/com/gorshkov/io/fileanalyzer/story.txt";
        String filePath = "./src/test/java/com/gorshkov/io/fileanalyzer/story.txt";
        int numberOfMatches = FileAnalyzer.numberOfMatches(filePath, "duck");
        assertEquals(5, numberOfMatches);
    }

    @Test
    void printAllSentencesWithWord() throws IOException {
        FileAnalyzer.printAllSentencesWithWord(FILE_PATH, "duck");

    }
}