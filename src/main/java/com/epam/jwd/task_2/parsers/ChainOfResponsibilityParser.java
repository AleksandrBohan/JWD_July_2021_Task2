package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class ChainOfResponsibilityParser {

    public String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public void parseIt(String path, String parser) throws WrongFileName, IOException {
        Pattern pattern = Pattern.compile(parser);

        Matcher matcher = pattern.matcher(readFile(path, StandardCharsets.UTF_8));

        File writingFile = new File("C:\\TsTemp\\FirstText.txt");

        try (FileWriter writer = new FileWriter("C:\\TsTemp\\FirstText.txt",
                false)) {

            while (matcher.find()) {
                writer.append(matcher.group(0));
                writer.append("\n");
                System.out.println("Found: " + matcher.group(0));
            }

        } catch (IOException ex) {
            System.err.println("Trouble with writing!");
        }

    }
}
