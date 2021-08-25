package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.TextObjects.Text;
import com.epam.jwd.task_2.reader.TextReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    private static final String SENTENCE_PARSER = "\\n*([^!.?]+?)([!.?])\\n*";

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    private List<String> text = new ArrayList<>();

    public List<String> parseSentences(String path, String generalParser, List<String> sentenceList,
                                       List<String> textList)
            {

        setText(textList);

        Pattern generalPattern = Pattern.compile(generalParser);

        Matcher generalMatcher = generalPattern.matcher(new TextReader().readFile(path, StandardCharsets.UTF_8));


        while (generalMatcher.find()) {
            //writer.append(generalMatcher.group(1));
            // writer.append("\n");
            new Text(generalMatcher.group(1), sentenceList).createText(generalMatcher.group(1), sentenceList);
            new Text(generalMatcher.group(0), textList).createText(generalMatcher.group(0), textList);
         //   System.out.println("Found sentence : " + generalMatcher.group(1));
            //  System.out.println("End of sentence!");

        }
      return sentenceList;
    }


   public void reversText(List<String> textList) throws IOException {

       System.out.println("\n" + "Roll back this text: " + "\n");
        for (String line : textList) {
            System.out.print(line);


        }
    }


    public static void main(String[] args) throws IOException {
        WordParser wordParser = new WordParser();
        SentenceParser sentenceParser = new SentenceParser();
        List<String> wordsSentences = new ArrayList<>();
        List<String> parseSentences = new ArrayList<>();
        List<String> originalText = new ArrayList<>();
        List<String> originalSentence = new ArrayList<>();
        List<String>parser = sentenceParser
                .parseSentences("ProgramFile.txt", SENTENCE_PARSER
                        ,parseSentences, originalText);

        for (int i = 0; i<parser.size()-1; i++) {
            System.out.println(parser.get(i));
            wordParser.sentenceParser(parser.get(i), wordsSentences, originalSentence);
        }
        wordsSentences.removeIf(item -> item == null || "".equals(item));
        for (int i = 0; i < wordsSentences.size()-1; i++){
            System.out.println(wordsSentences.get(i));
        }


        wordParser.reversSentence(originalSentence);
        sentenceParser.reversText(originalText);





    }
    public static String getSentenceParser() {
        return SENTENCE_PARSER;
    }

    @Override
    public String toString() {
        return "SentenceParser{" +
                "text=" + text +
                '}';
    }
}
