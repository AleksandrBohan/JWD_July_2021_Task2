package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsParser {

    private static final String WORD_PARSER = "(\\w+)|[?;:.,!\"]";

    public void parseIt(String text, String parser, String path) throws WrongFileName {
        Pattern pattern = Pattern.compile(parser);

        Matcher matcher = pattern.matcher(text);

        new FileParser().checkFilePath(path);

        try (FileWriter writer = new FileWriter(path, true)) {

            while (matcher.find()) {
                writer.write(matcher.group());
                System.out.println("Found: " + matcher.group(0) +
                        " at position " + matcher.start() + " - " +
                        matcher.end());

            }
        } catch (IOException ex) {
            System.err.println("Trouble with writing!");
        }
    }

    public String getWordParser() {
        return WORD_PARSER;
    }

    public static void main(String[] args) {



    }
}
