package com.epam.jwd.task_2.app;

import com.epam.jwd.task_2.exceptions.WrongAnswerException;
import com.epam.jwd.task_2.functions.Functions;
import com.epam.jwd.task_2.parsers.SentenceParser;
import com.epam.jwd.task_2.parsers.WordParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;


public class ParserApp {

   private List<String> wordsSentences = new ArrayList<>();
   private List<String> parseSentences = new ArrayList<>();
   private List<String> originalSentence = new ArrayList<>();
   private List<String> originalText = new ArrayList<>();

    private static final Logger logger = LogManager.getLogger(ParserApp.class);

    public  <K, V extends Comparable<? super K>> Map<Integer, String>
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


    public void function5_reverse() {

        List<String>parser = new SentenceParser()
                .parseSentences("ProgramFile.txt", SentenceParser.getSentenceParser(),
                        parseSentences, originalText);

        for (int i = 0; i<parser.size(); i++){
            try {
                new Functions().reverseWords(parser.get(i));
            } catch (IOException e) {
                logger.log(Level.ERROR, "IOException in function5_reverse() method", e);
            }
            System.out.println();
            System.out.println();
        }

    }

    void callFunction12(int sizeOfWords) {

        List<String>parser = new SentenceParser()
                .parseSentences("ProgramFile.txt", SentenceParser.getSentenceParser(),
                        parseSentences, originalText);

        for (int i = 0; i<parseSentences.size(); i++){
            new WordParser().sentenceParser(parser.get(i),wordsSentences, originalSentence);
        }

        wordsSentences.removeIf(item -> item == null || "".equals(item));


        for (int i = 0; i < wordsSentences.size(); i++){

            Functions functions = new Functions();
            System.out.println(functions.formatText12(wordsSentences.get(i), sizeOfWords));

        }


    }

    List<String> getTextConstructor() throws IOException {

        List<String> parser = new SentenceParser()
                .parseSentences("ProgramFile.txt", SentenceParser.getSentenceParser(),
                        parseSentences, originalText);

        for (int i = 0; i<parser.size()-1; i++) {
            new WordParser().sentenceParser(parser.get(i), wordsSentences,
                    originalSentence);
        }
        wordsSentences.removeIf(item -> item == null || "".equals(item));
        for (int i = 0; i < wordsSentences.size()-1; i++){
            System.out.println(wordsSentences.get(i));
        }

            return wordsSentences;

    }

    void getRollBack(List<String> parseSentences) throws IOException {
        new WordParser().reversSentence(originalSentence);
        new SentenceParser().reversText(originalText);
    }

    void getFunction() throws IOException, WrongAnswerException {
        List<String> reverseList = new ArrayList<>();
        Map<Integer, String> sortMap = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What function do you want to do?..."
                + "\n" + "1 - " + "\n" + "2 - " + "\n" + "3 - ");
        int choiseNumber = scanner.nextInt();

        if (choiseNumber == 1) {
            callFunction12(4);
        } else if (choiseNumber == 2) {
            sortMapByValue(new Functions().sentenceOrder());
        } else if (choiseNumber == 3) {
            function5_reverse();
        } else {
            logger.error("Input isn't valid! Personal exception");
            throw new WrongAnswerException("There was input other number here!" +
                    "(This number isn't valid)", choiseNumber);

        }
    }


    public static void main(String[] args) throws IOException, WrongAnswerException {
        List<String> rollBackList = new ArrayList<>();
        ParserApp parserApp = new ParserApp();
        parserApp.getFunction();
        parserApp.getTextConstructor();
        parserApp.getRollBack(rollBackList);

    }


    public List<String> getWordsSentences() {
        return wordsSentences;
    }

    public void setWordsSentences(List<String> wordsSentences) {
        this.wordsSentences = wordsSentences;
    }

    public List<String> getParseSentences() {
        return parseSentences;
    }

    public void setParseSentences(List<String> parseSentences) {
        this.parseSentences = parseSentences;
    }

    public List<String> getOriginalSentence() {
        return originalSentence;
    }

    public void setOriginalSentence(List<String> originalSentence) {
        this.originalSentence = originalSentence;
    }

    public List<String> getOriginalText() {
        return originalText;
    }

    public void setOriginalText(List<String> originalText) {
        this.originalText = originalText;
    }
}
