package com.epam.jwd.task_2.composite;

import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.parsers.ChainOfResponsibilityParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Parsing {

    void addParser(String path, String parser, List list) throws IOException, WrongFileName;
    void removeParser(String path, String parser, List list) throws IOException;

    }
    

