package com.epam.jwd.task_2.app;

import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.functions.Functions;
import com.epam.jwd.task_2.parsers.SentenceParser;
import com.epam.jwd.task_2.parsers.WordParser;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;


public class ParserApp {

    public static <K, V extends Comparable<? super K>> Map<Integer, String>
    sortMapByValue( Map<Integer, String> map )
    {
        Map<Integer,String> orderMap = new LinkedHashMap<>();
        Stream<Map.Entry<Integer, String>> st = map.entrySet().stream();

        st.sorted(Comparator.comparing(e -> e.getKey()))
                .forEach(e ->orderMap.put(e.getKey(),e.getValue()));

        orderMap.entrySet()
                .stream()
                .forEach(System.out::println);

        return orderMap;
    }


    public void function5_reverse(List<String> wordsList) throws IOException, WrongFileName {
        List<java.lang.String> parseSentences = new ArrayList<>();
        List<java.lang.String>parser = new SentenceParser()
                .parseSentences("ProgramFile.txt", SentenceParser.getSentenceParser(), parseSentences);

        for (int i = 0; i<parser.size(); i++){
            new Functions().reverseWords(parser.get(i));
        }

    }

    void callFunction6() throws IOException, WrongFileName {
      List<String> words = new ArrayList<>();
      List <String> wordsList = new WordParser().getWordsFromSentences(words);
      List <String> wordsForSorting = new ArrayList<>();
      Functions functions = new Functions();
        System.out.println(wordsList.size());
       // new PunctuationMarksParser().parseText(words);
        for (int i = 0; i < words.size(); i++){
            System.out.println(words.get(i));

        }
        functions.alphabetOrder(words);
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

    List<String> getTextConstructor() throws IOException, WrongFileName {
        List<String> wordsSentences = new ArrayList<>();
        List<String> parseSentences = new ArrayList<>();
        List<String>parser = new SentenceParser()
                .parseSentences("ProgramFile.txt", SentenceParser.getSentenceParser(), parseSentences);

        for (int i = 0; i<parser.size()-1; i++) {
            new WordParser().sentenceParser(parser.get(i), wordsSentences);
        }
        wordsSentences.removeIf(item -> item == null || "".equals(item));
        for (int i = 0; i < wordsSentences.size()-1; i++){
            System.out.println(wordsSentences.get(i));
        }

            return wordsSentences;

    }

    void getRollBack(List<String> parseSentences) throws IOException {
        new WordParser().reversSentence(parseSentences);
        new SentenceParser().reversText(parseSentences);
    }

    void getFunction() throws IOException, WrongFileName {
        List<String> reverseList = new ArrayList<>();
        Map<Integer, String> sortMap = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What function do you want to do?..."
                + "\n" + "1 - " + "\n" + "2 - " + "\n" + "3 - "  );
        int choiseNumber = scanner.nextInt();

        if (choiseNumber == 1) {
            callFunction12(4);
        }
        if (choiseNumber == 2){
            sortMapByValue(new Functions().sentenceOrder());
        }
        if (choiseNumber == 3){
            function5_reverse(reverseList);
        }
    }

    public static void main(String[] args) throws IOException, WrongFileName {
        List<String> rollBackList = new ArrayList<>();
        ParserApp parserApp = new ParserApp();
        parserApp.getFunction();
        parserApp.getTextConstructor();
        parserApp.getRollBack(rollBackList);
        //System.out.println(5/5);
    }


}
