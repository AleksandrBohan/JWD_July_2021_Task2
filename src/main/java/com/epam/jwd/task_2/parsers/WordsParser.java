package com.epam.jwd.task_2.parsers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsParser {

    private static final String wordParser = "(\\w+)|[?;:.,!\"]";

    public void parseIt(String text, String parser) {
        Pattern pattern = Pattern.compile(parser);

        Matcher matcher = pattern.matcher(text);

        try (FileWriter writer = new FileWriter("ProgramText.txt", false)) {
            while (matcher.find()) {
                writer.write(matcher.group());
                writer.flush();
                System.out.println("Found: " + matcher.group(0) +
                        " at position " + matcher.start() + " - " +
                        matcher.end());

            }
        } catch (IOException ex) {
            System.err.println("Trouble with writing!");
        }
    }

    public String getWordParser() {
        return wordParser;
    }

    public static void main(String[] args) {
        WordsParser wordsParser = new WordsParser();

        try (FileReader fileReader = new FileReader("ProgramText.txt")) {

            int c;
            while ((c = fileReader.read()) != -1) {

                System.out.print((char) c);
            }

            wordsParser.parseIt(String.valueOf((char) c),
                    wordsParser.getWordParser());
        } catch (IOException e) {
            System.err.println("Trouble with reading!");
        }
    }
}
