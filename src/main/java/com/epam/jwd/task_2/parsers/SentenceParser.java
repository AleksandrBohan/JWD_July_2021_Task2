package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.TextObjects.Sentence;
import com.epam.jwd.task_2.TextObjects.Text;
import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.reader.TextReader;
import com.epam.jwd.task_2.writer.TextWriter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    private static final String SENTENCE_PARSER = "\\n*([^!.?]+?([!.?]))\\n*";

    private List<Sentence> text = new ArrayList<>();

    public String parseSentences(String path, String generalParser, int groupOfParser)
            throws WrongFileName, IOException {
        Pattern generalPattern = Pattern.compile(generalParser);

        Matcher generalMatcher = generalPattern.matcher(new TextReader().readFile(path, StandardCharsets.UTF_8));

        while (generalMatcher.find()) {

           // writer.append(generalMatcher.group(groupOfParser));
            //writer.append("\n");
            new Text().createText(generalMatcher.group(groupOfParser), text);
            System.out.println("Found: " + generalMatcher.group(groupOfParser));
        }
        return String.valueOf(new Text().getSentences());

    }

    public void hh() throws IOException, WrongFileName {
        parseSentences("ProgramFile.txt", SENTENCE_PARSER, 0);
        new Text().getContent(Collections.singletonList(parseSentences("ProgramFile.txt", SENTENCE_PARSER, 0)));
    }

    public static void main(String[] args) throws IOException, WrongFileName {
        new SentenceParser().parseSentences("ProgramFile.txt", SENTENCE_PARSER, 0);
    }

    @Override
    public String toString() {
        return "SentenceParser{" +
                "text=" + text +
                '}';
    }
}
