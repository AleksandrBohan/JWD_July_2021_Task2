package com.epam.jwd.task_2.chain_of_responsibilyty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        TextParts textParts = new TextParts(Collections.singletonList(new ParsingParts()));
        getParsersChain().getNameParser(TextInstruments.WORDS_AND_PUNCTUATION, textParts);
        System.out.println(textParts);
    }
    private static Parsing getParsersChain(){
        Parsing wordsParser = new WordsPart(null);
        Parsing sentenceParser = new SentencePart(wordsParser);
        return new TextPart(sentenceParser);
    }
}
