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


    public void function5_reverse(String path) {
        List<String>parser = new SentenceParser()
                .parseSentences(path, SentenceParser.getSentenceParser(),
                        parseSentences, originalText);

        for (int i = 0; i<parser.size(); i++){
                new WordParser().sentenceParser(parser.get(i), wordsSentences, originalSentence);
                new Functions().reverseWords(parser.get(i));
        }

        try {
            getRollBack();
        } catch (IOException e) {
            logger.log(Level.ERROR, "IOException getRollBack() method in function5_reverse() method");
        }
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
            System.out.print(new Functions()
                    .formatText12(wordsSentences.get(i), sizeOfWords));

        }
        try {
            getRollBack();
        } catch (IOException e) {
            logger.log(Level.ERROR, "IOException in callFunction12() method");
        }

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
                "change the first word with the last without changing the length of the sentence" + "\n" +
                "0 - exit from this app");

        int choiseNumber = scanner.nextInt();

        if (choiseNumber == 0){
            System.exit(0);
        }
        else if (choiseNumber == 1) {
            callFunction12(4, pathToFile);
        }
        else if (choiseNumber == 2) {
            sentenceOrder("ProgramFile.txt");
        }
        else if (choiseNumber == 3) {
            function5_reverse(pathToFile);
        }
        else {
            try {
                throw new WrongAnswerException("There was input other number here!" +
                        "(This number isn't valid)", choiseNumber);
            } catch (WrongAnswerException e) {
                logger.error("Input isn't valid! Personal exception");
            }
        }

    }


    public static void main(String[] args) throws IOException, WrongAnswerException {
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
