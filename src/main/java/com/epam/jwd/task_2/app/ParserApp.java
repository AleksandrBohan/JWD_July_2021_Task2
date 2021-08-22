package com.epam.jwd.task_2.app;

import com.epam.jwd.task_2.TextObjects.Composite;
import com.epam.jwd.task_2.TextObjects.Sentence;
import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.parsers.SentenceParser;
import com.epam.jwd.task_2.parsers.WordParser;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ParserApp {

void getFunction() throws IOException, WrongFileName {
    Scanner scanner = new Scanner(System.in);
    System.out.println("What function do you want to do?..."
            + "\n" + "1 - " + "\n" + "2 - " + "\n" + "3 - "  );
    int choiseNumber = scanner.nextInt();

    if (choiseNumber == 1) {
        new SentenceParser().parseSentences("ProgramFile.txt",
                SentenceParser.getSentenceParser(), 0);

       new WordParser().parseWords("ProgramFile.txt",
               WordParser.getWordParser(), 0);
     //  new WordParser().reversSentence();
      // new SentenceParser().reversText();


    }
}

    public static void main(String[] args) throws IOException, WrongFileName {
        new ParserApp().getFunction();
    }


}
