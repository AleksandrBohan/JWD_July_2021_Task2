package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentencesParser {

    private static final String SENTENCE_PARSER = "([^(\\\\.|!|\\\\?)]+)(\\.|!|\\?)";

    public void parseIt(String parser) throws WrongFileName {
        Pattern pattern = Pattern.compile(parser);

       //TODO Matcher matcher = pattern.matcher(text);



       /* while (matcher.find()) {
            System.out.println("Found: " + matcher.group(0) +
                    " at position " + matcher.start() + " - " +
                    matcher.end());
        }*/

    }



    public static void main(String[] args) {
       /* SentencesParser sentencesParser = new SentencesParser();
        sentencesParser.parseIt("Ajhffj kfl fkk f fkkf kf. " +
                "ddjjd kjfdk kd kdkd kd  kdk lldk   kdk!" +
                "jfkfk kfkk kfkkfd lldl?", sentencesParser.getSentenceParce());*/
        //TODO
    }

}
