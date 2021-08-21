package com.epam.jwd.task_2.text;

import com.epam.jwd.task_2.exceptions.WrongAnswerException;
import com.epam.jwd.task_2.reader.TextReader;
import com.epam.jwd.task_2.writer.TextWriter;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OriginalText {

    private String pathToFile;

    public void rollBackChanges(List<Character> list, String path) throws WrongAnswerException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want roll back this text file?: \n" +
                "yes/no");
        String keyWord = scanner.nextLine();
        if (keyWord.equals("yes")) {
        //    new TextReader().readFile(list, path);
        } else if (keyWord.equals("no")) {
            System.out.println("Okey, I understand!");
        } else {
            throw new WrongAnswerException("Inwalid key word", keyWord);
        }
    }
}
