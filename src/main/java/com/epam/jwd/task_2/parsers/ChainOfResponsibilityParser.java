package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class ChainOfResponsibilityParser {

    private List<String> list = new ArrayList<>();

    public String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public void parseIt(String path, String parser) throws WrongFileName, IOException {
        Pattern pattern = Pattern.compile(parser);

        Matcher matcher = pattern.matcher(readFile(path, StandardCharsets.UTF_8));

        File writingFile = new File("ProgramFile.txt");

        try (FileWriter writer = new FileWriter("ProgramFile.txt",
                false)) {

            while (matcher.find()) {
                writer.write(matcher.group(0));
                writer.append("\n");
                list.add(matcher.group(0));
                System.out.println("Found: " + matcher.group(0));
            }

        } catch (IOException ex) {
            System.err.println("Trouble with writing!");
        }

    }

    public void recoverText(String path, String parser) throws IOException {
        int counter = 0;
        Pattern pattern = Pattern.compile(parser);

        Matcher matcher = pattern.matcher(readFile(path, StandardCharsets.UTF_8));

        try (FileWriter writer = new FileWriter("ProgramFile.txt",
                false)) {

            while (matcher.find()) {
                if (counter > 3){
                    writer.append("\n");
                }
                writer.append(matcher.group(2));
                System.out.print(matcher.group(2));
                counter++;
            }

        } catch (IOException ex) {
            System.err.println("Trouble with writing!");
        }




            }
        /*Pattern pattern = Pattern.compile(parser);

        Matcher matcher = pattern.matcher(readFile(path, StandardCharsets.UTF_8));

        File writingFile = new File("ProgramFile.txt");

        try (FileWriter writer = new FileWriter("ProgramFile.txt",
                false)) {

            while (matcher.find()) {
                writer.append(matcher.group(1));
                writer.append(" ");
                System.out.print(matcher.group(0) + " ");
            }

        } catch (IOException ex) {
            System.err.println("Trouble with writing!");
        }*/

        }


