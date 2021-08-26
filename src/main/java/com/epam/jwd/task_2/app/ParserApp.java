package com.epam.jwd.task_2.app;

import com.epam.jwd.task_2.exceptions.WrongAnswerException;
import com.epam.jwd.task_2.functions.Functions;
import com.epam.jwd.task_2.parsers.SentenceParser;
import com.epam.jwd.task_2.parsers.WordParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;


public class ParserApp {

   private List<String> wordsSentences = new ArrayList<>();

   private List<String> parseSentences = new ArrayList<>();

   private List<String> originalSentence = new ArrayList<>();

   private List<String> originalText = new ArrayList<>();

    private Map<Integer, String> sentenceOrderMap = new TreeMap<>();

   private static final Logger logger = LogManager.getLogger(ParserApp.class);

    public void sentenceOrder(String pathToFile) {
        int sizeBefore;
        int sizeAfter;

        List<String>parser = new SentenceParser()
                .parseSentences(pathToFile,
                        SentenceParser.getSentenceParser(),
                        parseSentences, originalText);

        for (int i = 0; i<parser.size(); i++){
            sizeBefore = wordsSentences.size();

            new WordParser().sentenceParser(parser.get(i), wordsSentences, originalSentence);

            wordsSentences.removeIf(item -> item == null || "".equals(item));

            sizeAfter = wordsSentences.size();

            int realSize = sizeAfter - sizeBefore;

            sentenceOrderMap.put(realSize, parser.get(i));

        }

             new Functions().sortMapByValue(sentenceOrderMap);


             new WordParser().reversSentence(originalSentence);
             new SentenceParser().reversText(originalText);

    }


    public void reverseWordsInSentence(String path) {
        List<String>parser = new SentenceParser()
                .parseSentences(path, SentenceParser.getSentenceParser(),
                        parseSentences, originalText);

        for (int i = 0; i<parser.size(); i++){
                new WordParser().sentenceParser(parser.get(i), wordsSentences, originalSentence);
            System.out.println("--------------------------------");
                new Functions().reverseWords(parser.get(i));
            System.out.println("--------------------------------");
        }

        try {
            getRollBack();
        } catch (IOException e) {
            logger.log(Level.ERROR, "IOException getRollBack() method in function5_reverse() method");
        }
    }

    public void deleteWordsBySize(int sizeOfWords, String pathToFile) {
        List<String>parser = new SentenceParser()
                .parseSentences(pathToFile, SentenceParser.getSentenceParser(),
                        parseSentences, originalText);

        for (int i = 0; i<parseSentences.size(); i++){
            new WordParser().sentenceParser(parser.get(i),wordsSentences, originalSentence);
        }

        wordsSentences.removeIf(item -> item == null || "".equals(item));

        for (int i = 0; i < wordsSentences.size(); i++){
            System.out.print(new Functions().formatText(wordsSentences.get(i), sizeOfWords));

        }
        try {
            getRollBack();
        } catch (IOException e) {
            logger.log(Level.ERROR, "IOException in callFunction12() method");
        }

    }

    void getRollBack() throws IOException {
        new WordParser().reversSentence(originalSentence);
        new SentenceParser().reversText(originalText);
    }

    void getFunction(String pathToFile) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n" + "What function do you want to do?..." + "\n\n"
                 + "1 - Remove all words of a given length starting with" +
                " a consonant from the text" + "\n" +
                "2 - Display all sentences of a given text in ascending order" +
                " of the number of words in each of them " + "\n" + "3 - In each sentence of the text, " +
                "change the first word with the last without changing the length of the sentence" + "\n");

        int chooseNumber = scanner.nextInt();

        if (chooseNumber == 1) {
            deleteWordsBySize(4, pathToFile);
        }
        else if (chooseNumber == 2) {
            sentenceOrder("ProgramFile.txt");
        }
        else if (chooseNumber == 3) {
            reverseWordsInSentence(pathToFile);
        }
        else {
            try {
                throw new WrongAnswerException("There was input other number here!" +
                        "(This number isn't valid)", chooseNumber);
            } catch (WrongAnswerException e) {
                logger.log(Level.ERROR, "Input isn't valid! Personal exception", e);
            }
        }

    }


    public static void main(String[] args) {
        ParserApp parserApp = new ParserApp();
        parserApp.getFunction("ProgramFile.txt");

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

    public Map<Integer, String> getSentenceOrderMap() {
        return sentenceOrderMap;
    }

    public void setSentenceOrderMap(Map<Integer, String> sentenceOrderMap) {
        this.sentenceOrderMap = sentenceOrderMap;
    }

    public static Logger getLogger() {
        return logger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParserApp parserApp = (ParserApp) o;
        return Objects.equals(wordsSentences, parserApp.wordsSentences) &&
                Objects.equals(parseSentences, parserApp.parseSentences) &&
                Objects.equals(originalSentence, parserApp.originalSentence) &&
                Objects.equals(originalText, parserApp.originalText) &&
                Objects.equals(sentenceOrderMap, parserApp.sentenceOrderMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordsSentences, parseSentences, originalSentence, originalText, sentenceOrderMap);
    }

    @Override
    public String toString() {
        return "ParserApp{" +
                "wordsSentences=" + wordsSentences +
                ", parseSentences=" + parseSentences +
                ", originalSentence=" + originalSentence +
                ", originalText=" + originalText +
                ", sentenceOrderMap=" + sentenceOrderMap +
                '}';
    }
}
