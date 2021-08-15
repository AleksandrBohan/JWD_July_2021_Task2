package com.epam.jwd.task_2.app;

import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.parsers.FileParser;
import com.epam.jwd.task_2.parsers.TextParser;
import com.epam.jwd.task_2.parsers.WordsParser;
import com.epam.jwd.task_2.text.TextAfterParsing;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static void main(String[] args) throws WrongFileName, IOException {
        ParserApp parserApp = new ParserApp();
        parserApp.getPathParser();
        parserApp.getTextAfterParse(WordsParser.class, "C:\\TsTemp\\ProgramText.txt");
    }
}
