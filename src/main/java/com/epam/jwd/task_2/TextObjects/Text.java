package com.epam.jwd.task_2.TextObjects;

import java.util.List;

public class Text implements Composite {

    private String text;

    List<? extends Text> sentences;

    public Text(String text, List<? extends Text> sentences) {

        setText(text);
        setSentences(sentences);

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<?> getSentences() {
        return sentences;
    }

    public void setSentences(List<? extends Text> sentences) {
        this.sentences = sentences;
    }

    public void createText(String sentence, List<Sentence> sentences){
        sentences.add(new Sentence(sentence, sentences));
    }

    @Override
    public void getContent(List<String> list) {
        for (String sentence : list){
            System.out.println(sentence);
        }
    }
}
