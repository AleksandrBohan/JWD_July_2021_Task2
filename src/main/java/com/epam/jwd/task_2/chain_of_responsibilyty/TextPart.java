package com.epam.jwd.task_2.chain_of_responsibilyty;

public class TextPart extends Parsing{

    public TextPart(Parsing nextParsing) {
        super(nextParsing);
    }

    @Override
    public void getNameParser(TextInstruments textInstruments, TextParts textParts) {
        if (TextInstruments.TEXT_PARSER.equals(textInstruments)) {
            textParts.getParserObjects().forEach(parser -> parser.getParsingNames().add("It is a text parser!"));
        } else if (nextParsing != null) {
            textParts.getParserObjects().forEach(parser -> parser.getParsingNames().add("It is a text parser!"));
            nextParsing.getNameParser(textInstruments,textParts);
        }
    }


    @Override
    public String toString() {
        return "TextPart{" +
                "nextParsing=" + nextParsing +
                '}';
    }
}
