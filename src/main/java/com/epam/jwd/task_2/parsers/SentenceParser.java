package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.TextObjects.Text;
import com.epam.jwd.task_2.reader.TextReader;


import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    private static final String SENTENCE_PARSER = "\\n*([^!.?]+?)([!.?])\\n*";

    private List<String> text = new ArrayList<>();


    public List<String> parseSentences(String path, String generalParser, List<String> sentenceList,
                                       List<String> textList) {
            setText(textList);

            Pattern generalPattern = Pattern.compile(generalParser);

            Matcher generalMatcher = generalPattern.matcher(new TextReader().readFile(path, StandardCharsets.UTF_8));

                        while (generalMatcher.find()) {
                            new Text().createText(generalMatcher.group(1), sentenceList);
                            new Text().createText(generalMatcher.group(0), textList);
                         //   System.out.println("Found sentence : " + generalMatcher.group(1));
                         // System.out.println("End of sentence!");  //TODO
                        }

               return sentenceList;
    }


    public void reversText(List<String> textList) {
        System.out.println("\n" + "Roll back this text: " + "\n");

        for (String line : textList) {
            System.out.print(line);
        }
    }

    public static String getSentenceParser() {
        return SENTENCE_PARSER;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SentenceParser that = (SentenceParser) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return "SentenceParser{" +
                "text=" + text +
                '}';
    }

}