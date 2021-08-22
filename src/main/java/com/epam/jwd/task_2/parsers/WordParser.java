package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.TextObjects.Sentence;
import com.epam.jwd.task_2.TextObjects.Text;
import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.reader.TextReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser {

    private static final String WORD_PARSER = "(\\w+)|[?;:.,!\"]";

    private List<Sentence> text = new ArrayList<>();

    public String parseSentences(String path, String generalParser, int groupOfParser)
            throws WrongFileName, IOException {
        Pattern generalPattern = Pattern.compile(generalParser);

        Matcher generalMatcher = generalPattern.matcher(new TextReader().readFile(path, StandardCharsets.UTF_8));

        while (generalMatcher.find()) {

            // writer.append(generalMatcher.group(groupOfParser));
            //writer.append("\n");
            new Sentence().createText(generalMatcher.group(groupOfParser), text);
            System.out.println("Found: " + generalMatcher.group(groupOfParser));
        }
        return String.valueOf(new Sentence().getWords());

    }

    public void hh() throws IOException, WrongFileName {
        parseSentences("ProgramFile.txt", WORD_PARSER, 0);
        new Text().getContent(Collections.singletonList(parseSentences("ProgramFile.txt", WORD_PARSER, 0)));
    }

    public static void main(String[] args) throws IOException, WrongFileName {
        new WordParser().parseSentences("ProgramFile.txt", WORD_PARSER, 0);
    }
}
