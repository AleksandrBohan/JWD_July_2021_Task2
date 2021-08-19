package com.epam.jwd.task_2.composite;

import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.parsers.WordsParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SentenceParsing implements Parsing {

    private List<Parsing> parsers = new ArrayList<>();

    private static final List<String> STRING_LIST = new ArrayList<>();

    public void add(Parsing parser) {
        parsers.add(parser);
    }

    public void remove(Parsing parser) {
        parsers.remove(parser);
    }

    @Override
    public void addParser(String path, String parser, List list) throws IOException, WrongFileName {
        new WordsParser().parseIt(path, parser, list);
    }

    @Override
    public void removeParser(String path, String parser, List list) throws IOException {
        new WordsParser().recoverText(path, parser, list);
    }

    public List<String> getList() {
        return STRING_LIST;
    }

}

