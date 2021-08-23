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

   List<String> sentenceParser(String sentenceLine){
       Pattern generalPattern = Pattern.compile(WORD_PARSER);

       Matcher generalMatcher = generalPattern.matcher(sentenceLine);

       while (generalMatcher.find()) {
           // writer.append(generalMatcher.group(1));
           // writer.append("\n");
           new Sentence(generalMatcher.group(0), sentenceArray).createSentence(generalMatcher.group(0), sentenceArray);
           System.out.println("Found: " + generalMatcher.group(0));
       }
       return sentenceArray;
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
