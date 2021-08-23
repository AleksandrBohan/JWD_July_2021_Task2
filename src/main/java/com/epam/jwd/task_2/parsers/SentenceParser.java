package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.TextObjects.Sentence;
import com.epam.jwd.task_2.TextObjects.Text;
import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.reader.TextReader;

import java.io.FileWriter;
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

    private static final String SENTENCE_PARSER = "\\n*([^!.?]+?([!.?]))\\n*";

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
                System.out.println("Found: " + generalMatcher.group(1));

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
        List<String> parseSentences = new ArrayList<>();
        List<String>parser = new SentenceParser()
                .parseSentences("ProgramFile.txt", SENTENCE_PARSER, parseSentences);

        for (int i = 0; i<parser.size(); i++){
            System.out.println(new WordParser().sentenceParser(parser.get(i)));
        }
        //TODO ADD PARAMETR  new WordParser().reversSentence();
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
