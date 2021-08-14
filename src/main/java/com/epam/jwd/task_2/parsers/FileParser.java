package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {

    //TODO DELETE IT! private static final String FILE_PARSER = "^\\w:\\\\.+\\.[t][x][t]";
    private static final String PATH_PARSER = "^\\w:\\\\.+\\.[t][x][t]";

    public void checkFilePath() throws WrongFileName {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input file path: ");

        String path = scanner.next();

        Pattern pattern = Pattern.compile(PATH_PARSER);

        Matcher matcher = pattern.matcher(path);
       if (matcher.find()) {
            System.out.println(matcher.group(0));

        }

    }
    public static String getFileParser() {
        return PATH_PARSER;
    }

    public static void main(String[] args) throws WrongFileName {
        FileParser fileParser = new FileParser();
        fileParser.checkFilePath();
    }
}
