package com.epam.jwd.task_2.exceptions;

public class WrongFileName extends Exception {

    private String filePath;

    public WrongFileName(String pathErrorMessage, String path){

        super(pathErrorMessage);

        this.filePath = path;
    }

    public String getFilePath() {
        return filePath;
    }


}
