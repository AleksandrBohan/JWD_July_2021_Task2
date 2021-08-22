package com.epam.jwd.task_2.app;

import com.epam.jwd.task_2.composite.Parsing;
import com.epam.jwd.task_2.composite.SentenceParsing;
import com.epam.jwd.task_2.composite.TextParsing;
import com.epam.jwd.task_2.exceptions.WrongAnswerException;
import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.parsers.*;
import com.epam.jwd.task_2.reader.TextReader;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ParserApp {

    public String getPathParser() throws WrongFileName {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input path to file: ");    //Method getPathParser() should be handed
                                                       // over to getTextAfterParse() as a parameter
        String filePath = scanner.nextLine();

      // new FileParser().checkFilePath(filePath);

       return filePath;
    }

    void getTextAfterParse(Object objectForParsing, String path) throws WrongFileName, IOException {
      //  new TextParser().choiseParsMethod(objectForParsing, path);
    }


    public static void main(String[] args) throws WrongFileName, IOException, WrongAnswerException {

     /*   Parsing textParsingFirst = new TextParsing(true);
        SentenceParsing sentenceParsingFirst = new SentenceParsing(true);

        SentenceParsing sentenceParsingSecond = new SentenceParsing(false);
        Parsing textParsingSecond = new TextParsing(false);*/





       // ParserApp parserApp = new ParserApp();
    //TODO USE when will finish! parserApp.getPathParser();
       /* new TextAfterParsing("C:\\TsTemp\\ProgramText.txt");
        new SentenceAfterParsing("C:\\TsTemp\\ProgramText.txt");
        parserApp.getTextAfterParse(SentencesPa.class, "C:\\TsTemp\\FirstText.txt");
        new OriginalText().rollBackChanges(list,"C:\\TsTemp\\ProgramText.txt");  */

      //  new TextParsing().addParser("ProgramFile.txt", SentencesPa.getSentenceParser(), list);
       // new SentenceParsing().addText("ProgramFile.txt", WordsPa.getReversedParser());
        //new SentenceParsing().removeParser("ProgramFile.txt", WordsPa.getReversedParser());
       //new TextParsing().removeParser("ProgramFile.txt", SentencesPa.getSentenceParser(), list);

    }
}
