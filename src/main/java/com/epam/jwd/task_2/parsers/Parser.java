package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.reader.TextReader;
import com.epam.jwd.task_2.writer.TextWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class Parser {

    public void parseIt(String path, String generalParser, int groupOfParser) throws WrongFileName, IOException {
        new TextWriter().writeFile(path, generalParser, groupOfParser);
    }


    public void recoverText(String path, String parser, int groupOfParser) throws IOException {

        Pattern pattern = Pattern.compile(parser);

        Matcher matcher = pattern.matcher(new TextReader().readFile(path, StandardCharsets.UTF_8));

        try (FileWriter writer = new FileWriter("ProgramFile.txt",
                false)) {

            while (matcher.find()) {
                writer.write(matcher.group(groupOfParser));
                System.out.print(matcher.group(groupOfParser));

            }

        } catch (IOException ex) {
            System.err.println("Trouble with writing!");
        }
    }


        }


