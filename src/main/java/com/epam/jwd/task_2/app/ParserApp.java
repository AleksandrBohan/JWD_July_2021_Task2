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

    public  <K, V extends Comparable<? super K>>
    Map<Integer, String> sortMapByValue(Map<Integer, String> map, String pathToFile) {

        Map<Integer,String> orderMap = new LinkedHashMap<>();
        Stream<Map.Entry<Integer, String>> st = map.entrySet().stream();

        st.sorted(Comparator.comparing(e -> e.getKey()))
                .forEach(e ->orderMap.put(e.getKey(),e.getValue()));

        orderMap.entrySet()
                .stream()
                .forEach(System.out::println);

            getRollBack(pathToFile);


        return orderMap;
    }


    public void function5_reverse(String pathToFile) {
        List<String>parser = new SentenceParser()
                .parseSentences(pathToFile, SentenceParser.getSentenceParser(),
                        parseSentences, originalText);

        for (int i = 0; i<parser.size(); i++){
                new Functions().reverseWords(parser.get(i));

        }
            getRollBack(pathToFile);

    }

    public void callFunction12(int sizeOfWords, String pathToFile) {
        List<String>parser = new SentenceParser()
                .parseSentences(pathToFile, SentenceParser.getSentenceParser(),
                        parseSentences, originalText);

        for (int i = 0; i<parseSentences.size(); i++){
            new WordParser().sentenceParser(parser.get(i),wordsSentences, originalSentence);
        }

        wordsSentences.removeIf(item -> item == null || "".equals(item));

        for (int i = 0; i < wordsSentences.size(); i++){
            new Functions()
                    .formatText12(wordsSentences.get(i), sizeOfWords);
        }
            getRollBack(pathToFile);


    }

    List<String> getTextConstructor(String pathToFile) {
        List<String> parser = new SentenceParser()
                .parseSentences(pathToFile, SentenceParser.getSentenceParser(),
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

    void getRollBack(String pathToFile) {
            new WordParser().reversSentence(originalSentence);
            new SentenceParser().reversText(originalText);

    }

    void getFunction() {
        Scanner pathScanner = new Scanner(System.in);
        System.out.println("Input path to file: ");
        String fileName = pathScanner.next();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n" + "What function do you want to do?..." + "\n\n"
                 + "1 - Remove all words of a given length starting with" +
                " a consonant from the text" + "\n" +
                "2 - Display all sentences of a given text in ascending order" +
                " of the number of words in each of them " + "\n" + "3 - In each sentence of the text, " +
                "change the first word with the last without changing the length of the sentence" + "\n" +
                "0 - exit from this app");

        int choiseNumber = scanner.nextInt();

        if (choiseNumber == 0){
            System.exit(0);
        }
        else if (choiseNumber == 1) {
            callFunction12(4, fileName);
        }
        else if (choiseNumber == 2) {
                sortMapByValue(new Functions().sentenceOrder(), fileName);
        }
        else if (choiseNumber == 3) {
            function5_reverse(fileName);//TODO outPut by sentencies!!!
        }
        else {
            try {
                throw new WrongAnswerException("There was input other number here!" +
                        "(This number isn't valid)", choiseNumber);
            } catch (WrongAnswerException e) {
                logger.error("Input isn't valid! Personal exception");
            }
        }
        getFunction();
    }


    public static void main(String[] args) throws IOException, WrongAnswerException {
        ParserApp parserApp = new ParserApp();
        parserApp.getFunction();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParserApp parserApp = (ParserApp) o;
        return Objects.equals(wordsSentences, parserApp.wordsSentences) &&
                Objects.equals(parseSentences, parserApp.parseSentences) &&
                Objects.equals(originalSentence, parserApp.originalSentence) &&
                Objects.equals(originalText, parserApp.originalText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordsSentences, parseSentences, originalSentence, originalText);
    }

    @Override
    public String toString() {
        return "ParserApp{" +
                "wordsSentences=" + wordsSentences +
                ", parseSentences=" + parseSentences +
                ", originalSentence=" + originalSentence +
                ", originalText=" + originalText +
                '}';
    }
}
