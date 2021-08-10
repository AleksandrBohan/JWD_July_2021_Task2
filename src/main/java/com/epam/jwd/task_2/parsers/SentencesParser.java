package com.epam.jwd.task_2.parsers;

public class SentencesParser {
    private int numberOfWords;
    private WordsParser wordsParser;
    String sentenseParser = "^[" + new WordsParser().getWordParser() + "]+$";


    public String getSentenseParser() {
        return sentenseParser;
    }

    public void setSentenseParser(String sentenseParser) {
        this.sentenseParser = sentenseParser;
    }
}
