package com.epam.jwd.task_2.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class TextReader {

    private String pathToFile;

    private Charset encoding;

    private static final Logger logger = LogManager.getLogger(TextReader.class);

    public static Logger getLogger() {
        return logger;
    }

    public String readFile(String path, Charset encoding) {
        setPathToFile(path);
        setEncoding(encoding);
               byte[] encoded = new byte[0];
               try {
                   encoded = Files.readAllBytes(Paths.get(path));
               } catch (IOException e) {
                   logger.log(Level.ERROR, "IOException in readFile() method!", e);
               }
               return new String(encoded, encoding);
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public Charset getEncoding() {
        return encoding;
    }

    public void setEncoding(Charset encoding) {
        this.encoding = encoding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextReader that = (TextReader) o;
        return Objects.equals(pathToFile, that.pathToFile) &&
                Objects.equals(encoding, that.encoding);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pathToFile, encoding);
    }

    @Override
    public String toString() {
        return "TextReader{" +
                "pathToFile='" + pathToFile + '\'' +
                ", encoding=" + encoding +
                '}';
    }
}



