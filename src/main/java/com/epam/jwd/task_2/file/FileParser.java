package com.epam.jwd.task_2.file;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.util.Scanner;

public class FileParser {

    private static final String FILE_PARSER = "\\w:(\\.+)\\.[t][x][t]";

    void checkFilePath(String filePath) throws WrongFileName{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input file path: ");

        String path = scanner.next();

        if (path.equals(filePath) == false){
            throw new WrongFileName("Incorrect file name", filePath);

        }
    }
}
