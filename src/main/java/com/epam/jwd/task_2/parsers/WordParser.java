package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.TextObjects.Sentence;
import com.epam.jwd.task_2.TextObjects.Word;
import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.reader.TextReader;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser {

    public static String getWordParser() {
        return WORD_PARSER;
    }

    private static final String WORD_PARSER = "(\\w+)|[?;:.,!\"={}()]|(\\s*)";   // TODO USE IT! (\w+)|[?;:.,!"={}()]|\s*

    private List<Word> sentence = new ArrayList<>();

    public List<Word> parseWords(String path, String generalParser, int groupOfParser)
            throws WrongFileName, IOException {
        Pattern generalPattern = Pattern.compile(generalParser);

        Matcher generalMatcher = generalPattern.matcher(new TextReader().readFile(path, StandardCharsets.UTF_8));


            try (FileWriter writer = new FileWriter("ProgramFile.txt",
                    false)) {
                while (generalMatcher.find()) {
                    writer.append(generalMatcher.group(groupOfParser));
              // writer.append("\n");
                new Sentence().createSentence(generalMatcher.group(groupOfParser), sentence);
                System.out.println("Found: " + generalMatcher.group(1));

            }


        }
        return sentence;
    }

   public void reversSentence() throws IOException {
        for (Object line : sentence) {

            System.out.println(line);
            try (FileWriter writer = new FileWriter("ProgramFile.txt",
                    false)) {
                writer.append((Character) line);

            }
        }
    }

    public static void main(String[] args) throws IOException, WrongFileName {
        new WordParser().parseWords("ProgramFile.txt", WORD_PARSER, 0);
    }
}
