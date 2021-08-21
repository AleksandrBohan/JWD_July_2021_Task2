package com.epam.jwd.task_2.chain_of_responsibilyty;

public class WordsPart extends Parsing {

    public WordsPart(Parsing nextParsing) {
        super(nextParsing);
    }

    @Override
    public void getNameParser(TextInstruments textInstruments, TextParts textParts) {
        if (TextInstruments.WORDS_AND_PUNCTUATION.equals(textInstruments)) {
            textParts.getParserObjects().forEach(parser -> parser.getParsingNames().add("It is a words parser!"));
        } else if (nextParsing != null) {
            textParts.getParserObjects().forEach(parser -> parser.getParsingNames().add("It is a words parser!"));
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
