package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {

    private static final String PATH_PARSER = "^\\w:\\\\.+\\.[t][x][t]";

    public void checkFilePath(String filePath) throws WrongFileName {
        Pattern pattern = Pattern.compile(PATH_PARSER);
        Matcher matcher = pattern.matcher(filePath);
        if(matcher.find()) {
            System.out.println("This is really true path");
        } else {
            throw new WrongFileName("Wrong path to file", filePath);
        }
    }
    public static String getFileParser() {
        return PATH_PARSER;
    }

}
