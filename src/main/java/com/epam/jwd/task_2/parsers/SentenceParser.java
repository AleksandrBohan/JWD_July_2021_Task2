package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.TextObjects.Text;
import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.reader.TextReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    public static String getSentenceParser() {
        return SENTENCE_PARSER;
    }

    private static final String SENTENCE_PARSER = "\\n*([^!.?]+?)([!.?])\\n*";

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    private List<String> text = new ArrayList<>();

    public List<String> parseSentences(String path, String generalParser, List<String> sentenceList)
            throws WrongFileName, IOException {

        Pattern generalPattern = Pattern.compile(generalParser);

        Matcher generalMatcher = generalPattern.matcher(new TextReader().readFile(path, StandardCharsets.UTF_8));


        while (generalMatcher.find()) {
            //writer.append(generalMatcher.group(1));
            // writer.append("\n");
            new Text(generalMatcher.group(1), sentenceList).createText(generalMatcher.group(1), sentenceList);
            new Text(generalMatcher.group(0), text).createText(generalMatcher.group(0), text);
         //   System.out.println("Found sentence : " + generalMatcher.group(1));
            //  System.out.println("End of sentence!");

        }
      return sentenceList;
    }


   public void reversText(List<String> textList) throws IOException {

       System.out.println("Roll back this text!");
        for (String line : textList) {
            System.out.print(line);


        }
    }


    public static void main(String[] args) throws IOException, WrongFileName {
        List<String> wordsSentences = new ArrayList<>();
        List<String> parseSentences = new ArrayList<>();
        List<String>parser = new SentenceParser()
                .parseSentences("ProgramFile.txt", SENTENCE_PARSER, parseSentences);

        for (int i = 0; i<parser.size()-1; i++) {
            new WordParser().sentenceParser(parser.get(i), wordsSentences);
        }
        wordsSentences.removeIf(item -> item == null || "".equals(item));
        for (int i = 0; i < wordsSentences.size()-1; i++){
            System.out.println(wordsSentences.get(i));
        }


        new WordParser().reversSentence(parseSentences);
        new SentenceParser().reversText(parseSentences);
       // new SentenceParser().parseSentences("ProgramFile.txt", SENTENCE_PARSER, parseSentences);




    }

    @Override
    public String toString() {
        return "SentenceParser{" +
                "text=" + text +
                '}';
    }
}
