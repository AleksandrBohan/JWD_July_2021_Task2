package com.epam.jwd.task_2.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;


public class TextWriter {

    private String lineForWriting;

    public void writeFile(String lineForWriting) throws IOException {

        try (FileWriter writer = new FileWriter("ProgramFile.txt",
                false)) {
            writer.append(lineForWriting);
            writer.append("\n");

            System.out.println("Found: " + lineForWriting);
        }


    }

    public String getLineForWriting() {
        return lineForWriting;
    }

    public void setLineForWriting(String lineForWriting) {
        this.lineForWriting = lineForWriting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextWriter that = (TextWriter) o;
        return Objects.equals(lineForWriting, that.lineForWriting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineForWriting);
    }

    @Override
    public String toString() {
        return "TextWriter{" +
                "lineForWriting='" + lineForWriting + '\'' +
                '}';
    }
}
