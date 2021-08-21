package com.epam.jwd.task_2.text;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.io.IOException;

public class SentenceAfterParsing {

    private String pathToFile;

    public SentenceAfterParsing(String pathToFile) throws IOException, WrongFileName {
        setPathToFile(pathToFile);
     //TODO   new WordsPa().parseIt(pathToFile, WordsPa.getWordParser());
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }


}
