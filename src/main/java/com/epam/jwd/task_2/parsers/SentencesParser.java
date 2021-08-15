package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.jwd.task_2.parsers.WordsParser.readFile;

public class SentencesParser {

    private static final String SENTENCE_PARSER = "\\s*([^!.?]+?([!.?]))";

    public void parseIt(String path) throws WrongFileName, IOException {
        Pattern pattern = Pattern.compile(SENTENCE_PARSER);

        Matcher matcher = pattern.matcher(readFile(path, StandardCharsets.UTF_8).trim());

        try (FileWriter writer = new FileWriter("C:\\TsTemp\\FirstText.txt",
                false)) {

            while (matcher.find()) {
                writer.append(matcher.group(0));
                writer.append("\n");
                writer.append("\n");
                System.out.println("Found: " + matcher.group(0));
            }

        } catch (IOException ex) {
            System.err.println("Trouble with writing!");
        }
    }



    public static void main(String[] args) throws IOException, WrongFileName {
      new SentencesParser().parseIt("C:\\TsTemp\\ProgramText.txt");
    }

}
