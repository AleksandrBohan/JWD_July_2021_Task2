package com.epam.jwd.task_2.app;

import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.parsers.FileParser;
import com.epam.jwd.task_2.parsers.WordsParser;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserApp {

    public String getPathParser() throws WrongFileName {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input path to file: ");
        String filePath = scanner.nextLine();

       new FileParser().checkFilePath(filePath);

       return filePath;
    }

    void getTextAfterParse(Object o) throws WrongFileName, IOException {
        if (o == new WordsParser()) {
            new WordsParser().parseIt("C:\\TsTemp\\ProgramText.txt");
        }
    }

    public static void main(String[] args) throws WrongFileName, IOException {
        ParserApp parserApp = new ParserApp();
        parserApp.getPathParser();
        parserApp.getTextAfterParse(new WordsParser());
    }
}
