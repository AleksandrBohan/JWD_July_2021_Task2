package com.epam.jwd.task_2.reader;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextReader {

    private String pathToFile;

    private Charset encoding;

    private static final Logger logger = LogManager.getLogger(TextReader.class);

    public String readFile(String path, Charset encoding)
           {
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
}



