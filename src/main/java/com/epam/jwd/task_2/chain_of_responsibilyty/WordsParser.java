package com.epam.jwd.task_2.chain_of_responsibilyty;

import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.writer.TextWriter;

import java.io.IOException;

public class WordsParser extends Parsing {

    private static final String WORD_PARSER = "(\\w+)|[?;:.,!\"]";

    private static final String REVERSED_PARSER = "\\s*(\\w+)|[?;:.,!\"](\\n*)";

    public WordsParser(Parsing nextParsing) {
        super(nextParsing);
    }

    public String parseWords(String path, String generalParser, int groupOfParser)
            throws WrongFileName, IOException {

        return new TextWriter().writeFile(path, generalParser, groupOfParser);

    }

    @Override
    public void getNameParser(TextInstruments textInstruments, TextParts textParts) throws IOException, WrongFileName {
        if (TextInstruments.WORDS_AND_PUNCTUATION_PARSER.equals(textInstruments)) {
            textParts.getParserObjects().forEach(parser -> {
                try {
                    parser.getParsingNames().add(parseWords("ProgramFile.txt", WORD_PARSER, 0));
                } catch (WrongFileName wrongFileName) {
                    wrongFileName.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            //parseWords("ProgramFile.txt", WORD_PARSER, 0);
        } else if (nextParsing != null) {
            textParts.getParserObjects().forEach(parser -> parser.getParsingNames().add("It is a words parser!"));
           // parseWords("ProgramFile.txt", WORD_PARSER, 0);
            nextParsing.getNameParser(textInstruments,textParts);
        }

    }

    @Override
    public String toString() {
        return "WordsPart{" +
                "nextParsing=" + nextParsing +
                '}';
    }
}
