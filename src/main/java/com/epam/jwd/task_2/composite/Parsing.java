package com.epam.jwd.task_2.composite;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Parsing {
    void addText(String path, String parser) throws IOException, WrongFileName;
    void removeParser(String path, String parser) throws IOException;
    
}
