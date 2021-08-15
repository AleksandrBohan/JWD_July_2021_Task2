package com.epam.jwd.task_2.writer;

import com.epam.jwd.task_2.reader.TextReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class TextWriter {

    private String pathToFile;

   public void writeFile() {

        try(FileOutputStream fos=new FileOutputStream("C:\\TsTemp\\ProgramText.txt")) {

            for (char symbol : new TextReader().getList()) {
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
