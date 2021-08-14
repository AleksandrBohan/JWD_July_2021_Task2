package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.util.Scanner;

public class TextParser {

    private WordsParser wordsParser;

    private SentencesParser sentencesParser;

    void choiseParsMethod() throws WrongFileName {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choise parse method: ");
        System.out.println("1 - parse by words");
        System.out.println("2 - parse by sentenses");

        int yourOption = scanner.nextInt();

        if (yourOption == 1){
            wordsParser.parseIt("ProgramText.txt", wordsParser.getWordParser(),
                    "ProgramText.txt");
        }

        if (yourOption == 2){
            sentencesParser.parseIt("dsfasd dsfadf dsf sdf a. . . . ", wordsParser.getWordParser());
        }
    }

    public static void main(String[] args) throws WrongFileName {
        TextParser textParser = new TextParser();
        textParser.choiseParsMethod();
    }

}
