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


public abstract class Parser {

    //private List <String> list = new ArrayList<>();

    public String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public void parseIt(String path, String generalParser, int groupOfParser) throws WrongFileName, IOException {
        Pattern generalPattern = Pattern.compile(generalParser);

       // Pattern additionalPattern = Pattern.compile(additionalParser);

        Matcher generalMatcher = generalPattern.matcher(readFile(path, StandardCharsets.UTF_8));



        File writingFile = new File("ProgramFile.txt");

        try (FileWriter writer = new FileWriter("ProgramFile.txt",
                false)) {

            while (generalMatcher.find()) {
                writer.append(generalMatcher.group(groupOfParser));
                writer.append("\n");
               // list.add(generalMatcher.group(0));
                System.out.println("Found: " + generalMatcher.group(groupOfParser));
            }

        } catch (IOException ex) {
            System.err.println("Trouble with writing!");
        }

    }

    public void recoverText(String path, String parser, int groupOfParser) throws IOException {
       // int counter = 0;

       // this.list = list;

        Pattern pattern = Pattern.compile(parser);

        Matcher matcher = pattern.matcher(readFile(path, StandardCharsets.UTF_8));

        try (FileWriter writer = new FileWriter("ProgramFile.txt",
                false)) {

           /* for (String s : list) {
                writer.write(s);
                System.out.println(s);
            }*/

            while (matcher.find()) {
              /*  if (counter > 3){
                    writer.append("\n");
                }*/
                writer.write(matcher.group(groupOfParser));
                System.out.print(matcher.group(groupOfParser));
               // counter++;
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


