package com.epam.jwd.task_2.composite;

import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.parsers.SentencesParser;
import com.epam.jwd.task_2.parsers.WordsParser;

import java.io.IOException;
import java.util.List;

public class SentenceParsing implements Parsing{


    @Override
    public void addText(String path, String parser) throws IOException, WrongFileName {
        new WordsParser().parseIt(path, parser);
    }

    @Override
    public void removeParser(String path, String parser) throws IOException {
        new WordsParser().recoverText(path, parser);
    }
}

