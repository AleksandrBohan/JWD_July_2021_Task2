package com.epam.jwd.task_2.parsers;

import java.util.ArrayList;
import java.util.List;

public class PunctuationMarksParser {

    private List<String> words = new ArrayList<>();
    private static final String WORD_PARSER = "[^A-Za-z0-9]|(\\s+)";

    public List<String> parseText(List<String> words) {

        for (int i = 0; i < words.size(); i++) {
                words.remove(i);

        }
        return words;
    }



    public static String getWordParser() {
        return WORD_PARSER;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
}
