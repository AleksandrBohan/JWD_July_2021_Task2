package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.io.IOException;

public class TextParser {

    public void choiseParsMethod(Object objectForParsing, String path) throws WrongFileName, IOException {
        if (objectForParsing == WordsPa.class){
          //  new WordsPa().parseIt(path, WordsPa.getWordParser());
        }

        if (objectForParsing == SentencesPa.class){
         //TODO new SentencesPa().parseIt(path, SentencesPa.getSentenceParser());
        }
    }

    public static void main(String[] args) throws WrongFileName, IOException {
        TextParser textParser = new TextParser();
        textParser.choiseParsMethod(WordsPa.class, "C:\\TsTemp\\ProgramText.txt");

    }

}
