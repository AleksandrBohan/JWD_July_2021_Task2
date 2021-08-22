package com.epam.jwd.task_2.functions;

import com.epam.jwd.task_2.TextObjects.Sentence;
import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.parsers.SentenceParser;
import com.epam.jwd.task_2.parsers.WordParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Functions {

   void function1() throws IOException, WrongFileName {
        List<Sentence> list = new SentenceParser().parseSentences("ProgramFile.txt",
                SentenceParser.getSentenceParser(), 0);
       Stream stream = list.stream()
        }



    public static void main(String[] args) throws IOException, WrongFileName {
       // new Functions().function1();
    }
}
