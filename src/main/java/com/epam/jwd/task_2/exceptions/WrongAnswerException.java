package com.epam.jwd.task_2.exceptions;

public class WrongAnswerException extends Exception {

    private String answerWord;

    public WrongAnswerException(String invalidWordMessage, String answer){

        super(invalidWordMessage);

        this.answerWord = answer;
    }

    public String getAnswerWord() {
        return answerWord;
    }

}
