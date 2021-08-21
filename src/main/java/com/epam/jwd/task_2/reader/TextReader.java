package com.epam.jwd.task_2.reader;

import com.epam.jwd.task_2.writer.TextWriter;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextReader {

    private String pathToFile;

    private Charset encoding;

    public String readFile(String path, Charset encoding)
            throws IOException {
        setPathToFile(path);
        setEncoding(encoding);
        byte[] encoded = Files.readAllBytes(Paths.get(path));
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



