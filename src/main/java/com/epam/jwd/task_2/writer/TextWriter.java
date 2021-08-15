package com.epam.jwd.task_2.writer;

import com.epam.jwd.task_2.reader.TextReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class TextWriter {

    private String pathToFile;

   public void writeFile(List<Character> list, String path) {

       File cloneFile = new File("C:\\TsTemp\\CloneParser.txt");

        try(FileOutputStream fos=new FileOutputStream(path)) {

            for (char symbol : list) {
                byte[] buffer = Character.toString(symbol).getBytes();

                fos.write(buffer, 0, buffer.length);
            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("The file has been written");

    }
}
