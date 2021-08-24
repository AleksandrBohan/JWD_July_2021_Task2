package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.TextObjects.Sentence;
import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser {

    private static final String WORD_PARSER = "(\\w+|[?;:.,!\"={}()])|(\\s*)";   // TODO USE IT! (\w+)|[?;:.,!"={}()]|\s*

    private List<String> sentenceArray = new ArrayList<>();

    private List<String> words = new ArrayList<>();

   public List<String> sentenceParser(String sentenceLine, List<String> writeWords){
       this.sentenceArray = writeWords;
       Pattern generalPattern = Pattern.compile(WORD_PARSER);

       Matcher generalMatcher = generalPattern.matcher(sentenceLine);

       while (generalMatcher.find()) {
           // writer.append(generalMatcher.group(1));
           // writer.append("\n");
           new Sentence(generalMatcher.group(0), writeWords).createSentence(generalMatcher.group(0), writeWords);
           System.out.println("Found word: " + generalMatcher.group(0));

       }
       System.out.println("End Of sentence!");
       return writeWords;
   }


   public List<String> getWordsFromSentences(List<String> wordsList) throws IOException, WrongFileName {
       List<String> parseSentences = new ArrayList<>();
       this.words = wordsList;
       List<String>parser = new SentenceParser()
               .parseSentences("ProgramFile.txt", SentenceParser.getSentenceParser(), parseSentences);

       for (int i = 0; i<parser.size(); i++){
           new WordParser().sentenceParser(parser.get(i), wordsList);
       }
       return wordsList;
   }


   public void reversSentence() throws IOException {

       System.out.println("Roll back these words!");
       for (String line : sentenceArray) {
           System.out.print(line);
           }

       }


    public static String getWordParser() {
        return WORD_PARSER;
    }

    public static void main(String[] args) throws IOException, WrongFileName {

    }


}
