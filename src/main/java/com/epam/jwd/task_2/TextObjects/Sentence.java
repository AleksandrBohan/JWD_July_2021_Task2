package com.epam.jwd.task_2.TextObjects;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Composite {

    private String sentence;

    private List<? extends Text> words = new ArrayList<>();

    public void createSentence(String word, List<String> words){
        words.add(new Word().getWord());
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void setWords(List<? extends Text> words) {
        this.words = words;
    }


    public List<? extends Text> getWords() {
        return words;
    }


    @Override
    public void getContent(List<String> list) {
        for (String word : list){
            System.out.println(word);
        }
    }
}

