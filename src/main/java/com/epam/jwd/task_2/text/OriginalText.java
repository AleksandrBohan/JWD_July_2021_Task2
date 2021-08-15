package com.epam.jwd.task_2.text;

import com.epam.jwd.task_2.reader.TextReader;
import com.epam.jwd.task_2.writer.TextWriter;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class OriginalText {

    private String pathToFile;

    private ArrayList<Character> symbolsList = new ArrayList<>();

    public void rollBackChanges(String path) {
        new TextReader().readFile(symbolsList);
    }

    public void rollBackChanges(){
        new TextWriter().writeFile();
    }
}
