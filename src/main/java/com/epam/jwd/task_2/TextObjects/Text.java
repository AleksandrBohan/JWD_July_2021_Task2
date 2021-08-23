package com.epam.jwd.task_2.TextObjects;

import java.util.List;

public class Text implements Composite {

    private String text;

    private Sentence sentenceObject;

    List<? extends Text> sentences;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<? extends Text> getSentences() {
        return sentences;
    }

    public void setSentences(List<? extends Text> sentences) {
        this.sentences = sentences;
    }

    public Sentence getSentenceObject() {
        return sentenceObject;
    }

    public void setSentenceObject(Sentence sentenceObject) {
        this.sentenceObject = sentenceObject;
    }

    public void createText(String sentence, List<String> sentences){
        new Sentence().setSentence(sentence);
        sentences.add(new Sentence().getSentence());
    }

    @Override
    public void getContent(List<String> list) {
        for (String sentence : list){
            System.out.println(sentence);
        }
    }
}
