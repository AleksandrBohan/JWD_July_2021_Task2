package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.TextObjects.Sentence;
import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser {

    private static final String WORD_PARSER = "(\\w+)|([?;:.,!\"={}()])|(\\s*)";   // TODO USE IT! (\w+)|[?;:.,!"={}()]|\s*

    private List<String> sentenceArray = new ArrayList<>();

    private List<String> words = new ArrayList<>();

    private List<String> previouSentence = new ArrayList<>();

   public List<String> sentenceParser(String sentenceLine, List<String> writeWords){
       Pattern generalPattern = Pattern.compile(WORD_PARSER);

       Matcher generalMatcher = generalPattern.matcher(sentenceLine);

       while (generalMatcher.find()) {
           // writer.append(generalMatcher.group(1));
           // writer.append("\n");
           new Sentence(generalMatcher.group(1), writeWords).createSentence(generalMatcher.group(1), writeWords);
           new Sentence(generalMatcher.group(0), sentenceArray).createSentence(generalMatcher.group(0), sentenceArray);
         //  System.out.println("Found word: " + generalMatcher.group(1));

       }

       //System.out.println("End Of sentence!");
       return writeWords;
   }


   public List<String> getWordsFromSentences(List<String> wordsList) throws IOException, WrongFileName {
       List<String> parseSentences = new ArrayList<>();
       List<String>parser = new SentenceParser()
               .parseSentences("ProgramFile.txt", SentenceParser.getSentenceParser(), parseSentences);

       for (int i = 0; i<parser.size(); i++){
           new WordParser().sentenceParser(parser.get(i), wordsList);
       }
       return wordsList;
   }

    public List<String> getSentenceWords(List<String> wordsList) throws IOException, WrongFileName {
        List<String> parseSentences = new ArrayList<>();
        this.words = wordsList;
        List<String>parser = new SentenceParser()
                .parseSentences("ProgramFile.txt", SentenceParser.getSentenceParser(), parseSentences);

        for (int i = 0; i<parser.size(); i++){
            new WordParser().sentenceParser(parser.get(i), wordsList);
        }
        return parser;
    }



   public void reversSentence(List<String> sentenceList) throws IOException {
       System.out.println("Roll back these words!");

       for (String line : sentenceList) {
           System.out.print("\n" + line + "\n");
           }
       }


    public static String getWordParser() {
        return WORD_PARSER;
    }

    public static void main(String[] args) throws IOException, WrongFileName {

    }


}
