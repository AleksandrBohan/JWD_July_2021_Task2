package com.epam.jwd.task_2.composite;

import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.parsers.WordsParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SentenceParsing implements Parsing {

    private boolean checkParser;

    private List<Parsing> parsers;

    public SentenceParsing(boolean checkParser) throws IOException, WrongFileName {

        setCheckParser(checkParser);

        if (checkParser == true) {
            addParser("ProgramFile.txt", WordsParser.getWordParser());
        }
        else if (checkParser == false){
            removeParser("ProgramFile.txt" , WordsParser.getWordParser());
        }

        this.parsers = new ArrayList<>();

    }

    // private static final List<String> STRING_LIST = new ArrayList<>();

    public void add(Parsing parser) {
        parsers.add(parser);
    }

    public void remove(Parsing parser) {
        parsers.remove(parser);
    }

    @Override
    public void addParser(String path, String parser) throws IOException, WrongFileName {
        new WordsParser().parseIt(path, parser, 0);
    }

    @Override
    public void removeParser(String path, String parser) throws IOException {
        new WordsParser().recoverText(path, parser, 0);
    }

    public List<Parsing> getParsers() {
        return parsers;
    }

    public void setParsers(List<Parsing> parsers) {
        this.parsers = parsers;
    }

    public boolean isCheckParser() {
        return checkParser;
    }

    public void setCheckParser(boolean checkParser) {
        this.checkParser = checkParser;
    }

   /* public List<String> getList() {
        return STRING_LIST;
    }*/

}

