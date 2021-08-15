package com.epam.jwd.task_2.text;

import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.parsers.SentencesParser;

import java.io.IOException;

public class TextAfterParsing {

    private String pathToFile;

    public TextAfterParsing(String pathToFile) throws IOException, WrongFileName {

        setPathToFile(pathToFile);
        new SentencesParser().parseIt(pathToFile, SentencesParser.getSentenceParser());

    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }
}
