package com.epam.jwd.task_2.app;

import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.parsers.SentenceParser;
import com.epam.jwd.task_2.parsers.WordParser;

import java.io.IOException;
import java.util.Scanner;


public class ParserApp {

void getFunction() throws IOException, WrongFileName {
    Scanner scanner = new Scanner(System.in);
    System.out.println("What function do you want to do?..."
            + "\n" + "1 - " + "\n" + "2 - " + "\n" + "3 - "  );
    int choiseNumber = scanner.nextInt();

    if (choiseNumber == 1) {

    }
}

    public static void main(String[] args) throws IOException, WrongFileName {
        new ParserApp().getFunction();
    }


}
