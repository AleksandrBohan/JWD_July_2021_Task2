package com.epam.jwd.task_2.composite;

import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.parsers.SentencesParser;


import java.io.IOException;
import java.util.List;

public class TextParsing implements Parsing {

    private boolean parserCheck;

    public TextParsing(boolean parserCheck) throws IOException, WrongFileName {
        setParserCheck(parserCheck);

        if (parserCheck == true){
            addParser("ProgramFile.txt", SentencesParser.getSentenceParser());
        }
        else if (parserCheck == false){
            removeParser("ProgramFile.txt", SentencesParser.getSentenceParser());
        }
    }

    @Override
    public void addParser(String path, String parser) throws IOException, WrongFileName {
        new SentencesParser().parseIt(path, parser, 0);
    }

    @Override
    public void removeParser(String path, String parser) throws IOException {
        new SentencesParser().recoverText(path ,parser, 1);
    }


    public boolean isParserCheck() {
        return parserCheck;
    }

    public void setParserCheck(boolean parserCheck) {
        this.parserCheck = parserCheck;
    }
}
