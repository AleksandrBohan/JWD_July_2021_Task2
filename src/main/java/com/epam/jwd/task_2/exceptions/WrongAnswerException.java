package com.epam.jwd.task_2.exceptions;

public class WrongAnswerException extends Exception {

    private int answerWord;

    public WrongAnswerException(String invalidWordMessage, int answer){

        super(invalidWordMessage);

        this.answerWord = answer;
    }

    public int getAnswerWord() {
        return answerWord;
    }

}
