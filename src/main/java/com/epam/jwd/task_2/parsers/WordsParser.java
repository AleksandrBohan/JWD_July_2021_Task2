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




    public class WordsParser {

        private static final String WORD_PARSER = "(\\w+)|[?;:.,!\"]";

        private List<String> list = new ArrayList();

        static String readFile(String path, Charset encoding)
                throws IOException
        {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded, encoding);
        }

        public void parseIt(String path) throws WrongFileName, IOException {
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


        }

        public static void main(String[] args) throws IOException, WrongFileName {
            new WordsParser().parseIt("C:\\TsTemp\\ProgramText.txt");
        }

    /*void output(){
        for (String s : list){
            System.out.println(s);
        }*///TODO
    }

