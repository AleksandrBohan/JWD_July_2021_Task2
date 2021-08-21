package com.epam.jwd.task_2.chain_of_responsibilyty;

import java.util.ArrayList;
import java.util.List;

public class TextParts {
    List<ParsingParts> parserObjects = new ArrayList<>();

    public TextParts(List<ParsingParts> parserObjects) {
        this.parserObjects = parserObjects;
    }

    public List<ParsingParts> getParserObjects() {
        return parserObjects;
    }

    public void setParserObjects(List<ParsingParts> parserObjects) {
        this.parserObjects = parserObjects;
    }

    @Override
    public String toString() {
        return "TextParts{" +
                "parserObjects=" + parserObjects +
                '}';
    }
}
