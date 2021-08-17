package com.epam.jwd.task_2.app;

import com.epam.jwd.task_2.exceptions.WrongAnswerException;
import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.parsers.FileParser;
import com.epam.jwd.task_2.parsers.SentencesParser;
import com.epam.jwd.task_2.parsers.TextParser;
import com.epam.jwd.task_2.parsers.WordsParser;
import com.epam.jwd.task_2.reader.TextReader;
import com.epam.jwd.task_2.text.OriginalText;
import com.epam.jwd.task_2.text.SentenceAfterParsing;
import com.epam.jwd.task_2.text.TextAfterParsing;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ParserApp {

    public String getPathParser() throws WrongFileName {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input path to file: ");    //Method getPathParser() should be handed
                                                       // over to getTextAfterParse() as a parameter
        String filePath = scanner.nextLine();

       new FileParser().checkFilePath(filePath);

       return filePath;
    }

    void getTextAfterParse(Object objectForParsing, String path) throws WrongFileName, IOException {
        new TextParser().choiseParsMethod(objectForParsing, path);
    }


    public static void main(String[] args) throws WrongFileName, IOException, WrongAnswerException {
        List<Character> list = new ArrayList<>();
        ParserApp parserApp = new ParserApp();
    //TODO USE when will finish! parserApp.getPathParser();
        new TextAfterParsing("C:\\TsTemp\\ProgramText.txt");
        new SentenceAfterParsing("C:\\TsTemp\\ProgramText.txt");
        parserApp.getTextAfterParse(SentencesParser.class, "C:\\TsTemp\\FirstText.txt");
        new OriginalText().rollBackChanges(list,"C:\\TsTemp\\ProgramText.txt");
    }
}
