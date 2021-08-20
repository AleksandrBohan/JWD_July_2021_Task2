    package com.epam.jwd.task_2.parsers;

    import com.epam.jwd.task_2.exceptions.WrongFileName;

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




    public class WordsParser extends ChainOfResponsibilityParser {

        private static final String WORD_PARSER = "(\\w+)|[?;:.,!\"]";

        private static final String REVERSED_PARSER = "\\s*(\\w+)|[?;:.,!\"](\\n*)";



        public static String getReversedParser() {
            return REVERSED_PARSER;
        }

        public static String getWordParser() {
            return WORD_PARSER;
        }

        @Override
        public String readFile(String path, Charset encoding) throws IOException {
            return super.readFile(path, encoding);
        }

        @Override
        public void parseIt(String path, String parser, int groupOfParser) throws WrongFileName, IOException {
            super.parseIt(path, WORD_PARSER, 0);
        }

        @Override
        public void recoverText(String path, String parser, int groupOfParser) throws IOException {
            super.recoverText(path, WORD_PARSER, 0);
        }

        /* public void parseIt(String path) throws WrongFileName, IOException {
            Pattern pattern = Pattern.compile(WORD_PARSER);

            Matcher matcher = pattern.matcher(readFile(path, StandardCharsets.UTF_8));

            try (FileWriter writer = new FileWriter("C:\\TsTemp\\FirstText.txt",
                    false)) {

                while (matcher.find()) {
                    writer.append(matcher.group(0));
                    writer.append("\n");
                    System.out.println("Found: " + matcher.group(0) +
                            " at position " + matcher.start() + " - " +
                            matcher.end());

                }

            } catch (IOException ex) {
                System.err.println("Trouble with writing!");
            }

        }*/ //TODO


    }

