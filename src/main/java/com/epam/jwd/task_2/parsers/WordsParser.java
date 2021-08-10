package com.epam.jwd.task_2.parsers;

public class WordsParser {

    private int numberOfSymbols;

    String wordParser;

    public WordsParser(){
        setWordParser("^\\s+\\w\\s+$");
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
}
