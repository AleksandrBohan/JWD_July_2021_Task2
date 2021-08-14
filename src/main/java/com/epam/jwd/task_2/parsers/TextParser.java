package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class TextParser {

    private WordsParser wordsParser;

    private SentencesParser sentencesParser;

    void choiseParsMethod(Object o, String path) throws WrongFileName, IOException {
        if (o == new WordsParser()){
            wordsParser.parseIt(path);
        }

        if (o == new SentencesParser()){
          //  sentencesParser.parseIt(wordsParser.parseIt(path));
        }
    }

    public static void main(String[] args) throws WrongFileName, IOException {
        TextParser textParser = new TextParser();
        textParser.choiseParsMethod(new WordsParser(), "C:\\TsTemp\\ProgramText.txt");
    }

}
