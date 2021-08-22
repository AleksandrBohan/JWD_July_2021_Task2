package com.epam.jwd.task_2.chain_of_responsibilyty;

import com.epam.jwd.task_2.exceptions.WrongFileName;
import com.epam.jwd.task_2.writer.TextWriter;

import java.io.IOException;

public class SentenceParser extends Parsing {

    private static final String SENTENCE_PARSER = "\\n*([^!.?]+?([!.?]))\\n*";

    public SentenceParser(Parsing nextParsing) {
        super(nextParsing);
    }

    public String parseSentences(String path, String generalParser, int groupOfParser)
            throws WrongFileName, IOException {

       return new TextWriter().writeFile(path, generalParser, groupOfParser);

    }

    @Override
    public void getNameParser(TextInstruments textInstruments, TextParts textParts)
            throws IOException, WrongFileName {
        if (TextInstruments.SENTENCES_PARSER.equals(textInstruments)) {
            textParts.getParserObjects().forEach(parser -> {
                try {
                    parser.getParsingNames().add(parseSentences("ProgramFile.txt", SENTENCE_PARSER, 0));
                } catch (WrongFileName wrongFileName) {
                    wrongFileName.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


           // parseSentences("ProgramFile.txt", SENTENCE_PARSER, 0);
        } else if (nextParsing != null) {
           // textParts.getParserObjects().forEach(parser -> parser.getParsingNames().add("It is a sentence parser!"));
           // parseSentences("ProgramFile.txt", SENTENCE_PARSER, 0);
            nextParsing.getNameParser(textInstruments,textParts);
        }
    }

    @Override
    public String toString() {
        return "SentencePart{" +
                "nextParsing=" + nextParsing +
                '}';
    }
}

