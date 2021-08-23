package com.epam.jwd.task_2.TextObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Text implements Composite {

    private String sentense;

    List<String> sentences = new ArrayList<>();

    public Text(String sentense, List<String> sentences) {
        setSentence(sentense);
        setSentences(sentences);
    }

    public String getSentense() {
        return sentense;
    }

    public void setSentence(String text) {
        this.sentense = sentense;
    }

    public List<String> getSentences() {
        return sentences;
    }

    public void setSentences(List<String> sentences) {
        this.sentences = sentences;
    }

    public void createText(String sentence, List<String> sentences){
        setSentence(sentence);
        setSentences(sentences);
        sentences.add(sentence);
    }

    @Override
    public void getContent() {
        setSentences(sentences);
        for (String sentence : sentences){
            System.out.println(sentence);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(sentense, text.sentense) &&
                Objects.equals(sentences, text.sentences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentense, sentences);
    }

    @Override
    public String toString() {
        return "Text{" +
                "sentense='" + sentense + '\'' +
                ", sentences=" + sentences +
                '}';
    }
}
