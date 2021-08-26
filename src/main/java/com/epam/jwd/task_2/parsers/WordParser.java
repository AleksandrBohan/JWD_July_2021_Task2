package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.TextObjects.Sentence;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser {

    private static final String WORD_PARSER = "(\\w+)|([?;:,!\"={}().])|(\\s*)";

    private List<String> sentenceArray = new ArrayList<>();

    public List<String> sentenceParser(String sentenceLine, List<String> writeWords,
                                       List<String> originalSentence){

        setSentenceArray(originalSentence);

        Pattern generalPattern = Pattern.compile(WORD_PARSER);

        Matcher generalMatcher = generalPattern.matcher(sentenceLine);

        while (generalMatcher.find()) {
            new Sentence()
                    .createSentence(generalMatcher.group(1), writeWords);
            new Sentence()
                    .createSentence(generalMatcher.group(0), originalSentence);

        }

        return writeWords;
    }

    public void reversSentence(List<String> sentenceList) {
        System.out.println("\n" + "Roll back these sentences: " + "\n");
        for (String line : sentenceList) {
            System.out.print(line);
        }
    }

    public static String getWordParser() {
        return WORD_PARSER;
    }

    public List<String> getSentenceArray() {
        return sentenceArray;
    }

    public void setSentenceArray(List<String> sentenceArray) {
        this.sentenceArray = sentenceArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordParser that = (WordParser) o;
        return Objects.equals(sentenceArray, that.sentenceArray);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentenceArray);
    }

    @Override
    public String toString() {
        return "WordParser{" +
                "sentenceArray=" + sentenceArray +
                '}';
    }
}