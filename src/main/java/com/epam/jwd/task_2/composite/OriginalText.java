package com.epam.jwd.task_2.composite;

import com.epam.jwd.task_2.reader.TextReader;
import com.epam.jwd.task_2.writer.TextWriter;

import java.util.ArrayList;
import java.util.List;

public class OriginalText implements Parsing {
    List<Character> list = new ArrayList<>();
    String path = "ProgramFile.txt";


    @Override
    public void writeFile(List<Character> list, String path) {
        new TextWriter().writeFile(list, path);
    }

    @Override
    public void readFile(List<Character> list, String path) {
        new TextReader().readFile(list, path);
    }

    public List<Character> getList() {
        return list;
    }

    public void setList(List<Character> list) {
        this.list = list;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
