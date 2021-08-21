package com.epam.jwd.task_2.chain_of_responsibilyty;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ChainOfResponsibility {
    public static void main(String[] args) throws IOException, WrongFileName {
        TextParts textParts = new TextParts(Collections.singletonList(new ParsingParts()));
        getParsersChain().getNameParser(TextInstruments.SENTENCES_PARSER, textParts);
        getParsersChain().getNextParsing();
        System.out.println(textParts);
    }
    private static Parsing getParsersChain(){
        Parsing wordsParser = new WordsParser(null);
        Parsing sentenceParser = new SentenceParser(wordsParser);
        return new TextPart(sentenceParser);
    }
}
