package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.util.Scanner;

public class TextParser {

    private WordsParser wordsParser;

    private SentencesParser sentencesParser;

    public TextParser(String text, String path) throws WrongFileName {

        sentencesParser.parseIt(text, sentencesParser.getSentenceParce(), path);
        wordsParser.parseIt(text, wordsParser.getWordParser(), path);

    }

}
