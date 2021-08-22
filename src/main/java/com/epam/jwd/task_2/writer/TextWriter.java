package com.epam.jwd.task_2.writer;

import com.epam.jwd.task_2.reader.TextReader;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextWriter {

    private String pathToFile;

    public String writeFile(String path, String generalParser, int groupOfParser) throws IOException {
        Pattern generalPattern = Pattern.compile(generalParser);
        Matcher generalMatcher = generalPattern.matcher(new TextReader().readFile(path, StandardCharsets.UTF_8));
        File writingFile = new File("ProgramFile.txt");

        String string = null;

        try (FileWriter writer = new FileWriter("ProgramFile.txt",
                false)) {

            while (generalMatcher.find()) {
                writer.append(generalMatcher.group(groupOfParser));
                writer.append("\n");

                System.out.println("Found: " + generalMatcher.group(groupOfParser));
            }
            string = new TextReader().readFile(path, StandardCharsets.UTF_8);

        } catch (IOException ex) {
            System.err.println("Trouble with writing!");
        }
        return string;
    }

}
