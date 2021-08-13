package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentencesParser {

    private final static String sentenceParce = "([^(\\\\.|!|\\\\?)]+)(\\.|!|\\?)";

    public void parseIt(String text, String parser, String path) throws WrongFileName {
        Pattern pattern = Pattern.compile(parser);

        Matcher matcher = pattern.matcher(text);

        new FileParser().checkFilePath(path);

        while (matcher.find()) {
            System.out.println("Found: " + matcher.group(0) +
                    " at position " + matcher.start() + " - " +
                    matcher.end());
        }

    }

    public String getSentenceParce() {
        return sentenceParce;
    }

    public static void main(String[] args) {
       /* SentencesParser sentencesParser = new SentencesParser();
        sentencesParser.parseIt("Ajhffj kfl fkk f fkkf kf. " +
                "ddjjd kjfdk kd kdkd kd  kdk lldk   kdk!" +
                "jfkfk kfkk kfkkfd lldl?", sentencesParser.getSentenceParce());*/
        //TODO
    }

}
