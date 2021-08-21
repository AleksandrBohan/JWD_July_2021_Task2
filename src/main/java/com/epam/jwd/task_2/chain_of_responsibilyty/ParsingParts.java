package com.epam.jwd.task_2.chain_of_responsibilyty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParsingParts {

    List <String> parsingNames = new ArrayList<>();

    public ParsingParts() {

    }

    public List<String> getParsingNames() {
        return parsingNames;
    }

    public void setParsingNames(List<String> parsingNames) {
        this.parsingNames = parsingNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParsingParts that = (ParsingParts) o;
        return Objects.equals(parsingNames, that.parsingNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parsingNames);
    }

    @Override
    public String toString() {
        return "ParsingParts{" +
                "parsingNames=" + parsingNames +
                '}';
    }
}
