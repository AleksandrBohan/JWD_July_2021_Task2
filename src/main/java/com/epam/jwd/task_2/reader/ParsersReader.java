package com.epam.jwd.task_2.reader;

import java.io.FileReader;
import java.io.IOException;

public class ParsersReader {
    public static void main(String[] args) {


        try(FileReader reader = new FileReader("ProgramText.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
}
