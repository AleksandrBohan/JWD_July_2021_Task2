package com.epam.jwd.task_2.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentencesParser {

    private String sentenceParce = "^\\s*|[A-Z].+[!?.]$";


    public SentencesParser() {

        setSentenceParce(sentenceParce);

    }

    public void parseIt(String text, String parser) {
        Pattern pattern = Pattern.compile(parser);

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Found: " + matcher.group(0) +
                    " at position " + matcher.start() + " - " +
                    matcher.end());

        }


    }

    public String getSentenceParce() {
        return sentenceParce;
    }

    public void setSentenceParce(String sentenceParce) {
        this.sentenceParce = sentenceParce;
    }

    public static void main(String[] args) {
        SentencesParser sentencesParser = new SentencesParser();
        sentencesParser.parseIt("Ajhffj kfl fkk f fkkf kf. " +
                "ddjjd kjfdk kd kdkd kd  kdk lldk   kdk!" +
                "jfkfk kfkk kfkkfd lldl?", sentencesParser.getSentenceParce());
    }

}
