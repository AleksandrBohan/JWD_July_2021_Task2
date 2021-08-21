package com.epam.jwd.task_2.chain_of_responsibilyty;

public class SentencePart extends Parsing {

    public SentencePart(Parsing nextParsing) {
        super(nextParsing);
    }

    @Override
    public void getNameParser(TextInstruments textInstruments, TextParts textParts) {
        if (TextInstruments.SENTENCE_PARSER.equals(textInstruments)) {
            textParts.getParserObjects().forEach(parser -> parser.getParsingNames().add("It is a sentence parser!"));
        } else if (nextParsing != null) {
            textParts.getParserObjects().forEach(parser -> parser.getParsingNames().add("It is a sentence parser!"));
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

