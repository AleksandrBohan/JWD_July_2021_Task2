package com.epam.jwd.task_2.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsParser {

    private int numberOfSymbols;

    public String getPunctuationMarksParser() {
        return punctuationMarksParser;
    }

    public void setPunctuationMarksParser(String punctuationMarksParser) {
        this.punctuationMarksParser = punctuationMarksParser;
    }

    private String punctuationMarksParser = "[?;:.,!]";

    private String wordParser = "\\w+";

    public WordsParser(){

        setWordParser(wordParser);
        setPunctuationMarksParser(punctuationMarksParser);
    }

    public void parseIt(String text, String parser){
        Pattern pattern = Pattern.compile(parser);

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            System.out.println("Found: " + matcher.group(0) +
                    " at position " + matcher.start() + " - " +
                    matcher.end());

        }
    }

    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }

    public String getWordParser() {
        return wordParser;
    }

    public void setWordParser(String wordParser) {
        this.wordParser = wordParser;
    }

    public static void main(String[] args) {
        WordsParser wordsParser = new WordsParser();

        wordsParser.parseIt("as. ajsod? {jsdni djsoj djoj didi d, :suu di",
                wordsParser.getWordParser());

        wordsParser.parseIt("as. ajsod? jsdni djsoj djoj didi d, :suu di",
                wordsParser.getPunctuationMarksParser());
    }
}
