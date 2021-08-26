package com.epam.jwd.task_2.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;


public class TextWriter {

    private String lineForWriting;

    private List<String> collectionForWriting;

    public String writeStringInFile(String lineForWriting, String pathToFile) throws IOException {
            setLineForWriting(lineForWriting);

        try (FileWriter writer = new FileWriter(pathToFile, false)) {

                writer.append(lineForWriting);
                writer.append("\n");

                //System.out.println("Found: " + lineForWriting);

        }
     return getLineForWriting();

    }

    public String writeCollectionInFile(List<String> collectionForWriting, String pathToFile) {
            setCollectionForWriting(collectionForWriting);
            try (FileWriter writer = new FileWriter(pathToFile,
                    false)) {
                for (String line : collectionForWriting){
                        writer.append(line);
                        writer.append("\n");


                //System.out.println("Found: " + lineForWriting);

                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        return getLineForWriting();
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
                "line for writing = '" + lineForWriting + '\'' +
                '}';
    }

    public List<String> getCollectionForWriting() {
        return collectionForWriting;
    }

    public void setCollectionForWriting(List<String> collectionForWriting) {
        this.collectionForWriting = collectionForWriting;
    }
}
