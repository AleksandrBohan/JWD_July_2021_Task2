package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class TextParser {

    public void choiseParsMethod(Object objectForParsing, String path) throws WrongFileName, IOException {
        if (objectForParsing == WordsParser.class){
            new WordsParser().parseIt(path, WordsParser.getWordParser());
        }

        if (objectForParsing == SentencesParser.class){
           new SentencesParser().parseIt(path, SentencesParser.getSentenceParser());
        }
    }

    public static void main(String[] args) throws WrongFileName, IOException {
        TextParser textParser = new TextParser();
        textParser.choiseParsMethod(WordsParser.class, "C:\\TsTemp\\ProgramText.txt");

    }

}
