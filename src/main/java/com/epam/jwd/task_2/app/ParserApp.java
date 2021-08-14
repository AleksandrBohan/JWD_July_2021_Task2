package com.epam.jwd.task_2.app;

import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.parsers.FileParser;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserApp {

    void getTextParser() throws WrongFileName {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input path to file: ");
        String filePath = scanner.nextLine();

        Pattern pattern = Pattern.compile(new FileParser().getFileParser());
        Matcher matcher = pattern.matcher(filePath);
        if(matcher.find()) {
            System.out.println("This is really true path");
        } else {
            throw new WrongFileName("Wrong path to file", filePath);
        }
    }

    public static void main(String[] args) throws WrongFileName {
        ParserApp parserApp = new ParserApp();
        parserApp.getTextParser();
    }
}
