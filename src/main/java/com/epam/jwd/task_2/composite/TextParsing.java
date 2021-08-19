package com.epam.jwd.task_2.composite;

import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.parsers.SentencesParser;

import java.io.IOException;
import java.util.List;

public class TextParsing implements Parsing {

    @Override
    public void addParser(String path, String parser, List list) throws IOException, WrongFileName {
        new SentencesParser().parseIt(path, parser, list);
    }

    @Override
    public void removeParser(String path, String parser, List list) throws IOException {
        new SentencesParser().recoverText(path,parser, list);
    }

}
