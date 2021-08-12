package com.epam.jwd.task_2.parsers;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsParser {

    private String wordParser = "(\\w+)|[?;:.,!\"]";

    public WordsParser(){

        setWordParser(wordParser);

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
    }
}
