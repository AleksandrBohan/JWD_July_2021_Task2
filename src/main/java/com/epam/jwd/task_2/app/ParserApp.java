package com.epam.jwd.task_2.app;

import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.functions.Functions;
import com.epam.jwd.task_2.parsers.SentenceParser;
import com.epam.jwd.task_2.parsers.WordParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ParserApp {

    void callFunction6() throws IOException, WrongFileName {
      List<String> words = new ArrayList<>();
      List <String> wordsList = new WordParser().getWordsFromSentences(words);
      List <String> wordsForSorting = new ArrayList<>();
      Functions functions = new Functions();
        System.out.println(wordsList.size());
        for (int i = 0; i < wordsList.size(); i++){
            System.out.println(wordsList
            .get(i));
            wordsForSorting.add(wordsList.get(i));

        }
        functions.alphabetOrder(wordsList);
    }

    void callFunction12(int sizeOfWords) throws IOException, WrongFileName {
        List<String> parseSentences = new ArrayList<>();
        List<String> writeWords = new ArrayList<>();
        List<String>parser = new SentenceParser()
                .parseSentences("ProgramFile.txt", SentenceParser.getSentenceParser(), parseSentences);

        for (int i = 0; i<parser.size(); i++){
            new WordParser().sentenceParser(parser.get(i), writeWords);
        }


        for (int i = 0; i < writeWords.size(); i++){
            Functions functions = new Functions();
            System.out.println(functions.formatText12(writeWords.get(i), sizeOfWords));

        }
    }

    void getFunction() throws IOException, WrongFileName {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What function do you want to do?..."
                + "\n" + "1 - " + "\n" + "2 - " + "\n" + "3 - "  );
        int choiseNumber = scanner.nextInt();

        if (choiseNumber == 1) {
            callFunction12(4);
        }
        if (choiseNumber == 2){
            callFunction6();
        }
    }

    public static void main(String[] args) throws IOException, WrongFileName {
        new ParserApp().getFunction();
        //System.out.println(5/5);
    }


}
