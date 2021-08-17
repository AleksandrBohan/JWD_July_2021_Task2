package com.epam.jwd.task_2.composite;

import java.util.ArrayList;
import java.util.List;

public interface Parsing {
    List<Character> list = new ArrayList<>();
    String path = "ProgramFile.txt";

    void writeFile(List<Character> list, String path);
    void readFile(List<Character> list, String path);    
    
}
