package com.epam.jwd.task_2.reader;

import com.epam.jwd.task_2.writer.TextWriter;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextReader {

    private String pathToFile;

    private List<Character> list = new ArrayList<>();

    public void readFile(List<Character> list){
        this.list = list;
        try(FileInputStream fin=new FileInputStream("C:\\TsTemp\\ProgramText.txt"))
        {
            System.out.printf("File size: %d bytes \n", fin.available());

            int i=-1;
            while((i=fin.read())!=-1){
                list.add((char)i);
                System.out.print((char)i);
            }

        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public List<Character> getList() {
        return list;
    }

    public void setList(List<Character> list) {
        this.list = list;
    }
}



