package com.epam.jwd.task_2.chain_of_responsibilyty;

import java.util.Objects;

public abstract class Parsing {

    protected Parsing nextParsing;

    public Parsing(Parsing nextParsing) {

        setNextParsing(nextParsing);

    }

    public Parsing getNextParsing() {
        return nextParsing;
    }

    public void setNextParsing(Parsing nextParsing) {
        this.nextParsing = nextParsing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parsing parsing = (Parsing) o;
        return Objects.equals(nextParsing, parsing.nextParsing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nextParsing);
    }

    @Override
    public String toString() {
        return "Parsing{" +
                "nextParsing=" + nextParsing +
                '}';
    }

    public abstract void getNameParser(TextInstruments textInstruments, TextParts textParts);

}
