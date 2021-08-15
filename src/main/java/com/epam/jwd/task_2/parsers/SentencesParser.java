package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class SentencesParser extends ChainOfResponsibilityParser{

    private static final String SENTENCE_PARSER = "\\s*([^!.?]+?([!.?]))";

    public static String getSentenceParser() {
        return SENTENCE_PARSER;
    }

    @Override
    public String readFile(String path, Charset encoding) throws IOException {
        return super.readFile(path, encoding);
    }

    @Override
    public void parseIt(String path, String parser) throws WrongFileName, IOException {
        super.parseIt(path, SENTENCE_PARSER);
    }

    /*public String parseIt(String path, String parser) throws WrongFileName, IOException {
        Pattern pattern = Pattern.compile(parser);

        Matcher matcher = pattern.matcher(readFile(path, StandardCharsets.UTF_8).trim());

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
        return path;
    }*/ //TODO





}
