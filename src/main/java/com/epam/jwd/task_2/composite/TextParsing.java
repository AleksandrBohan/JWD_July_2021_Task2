package com.epam.jwd.task_2.composite;

import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.parsers.SentencesParser;

import java.io.IOException;
import java.util.List;

public class TextParsing implements Parsing {

    @Override
    public void addText(String path, String parser) throws IOException, WrongFileName {
        new SentencesParser().parseIt(path, parser);
    }

    @Override
    public void removeParser(String path, String parser) throws IOException {
        new SentencesParser().recoverText(path,parser);
    }
}
