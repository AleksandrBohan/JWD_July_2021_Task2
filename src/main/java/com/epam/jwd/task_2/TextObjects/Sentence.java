package com.epam.jwd.task_2.TextObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence {

    private String word;

    private List<String> words = new ArrayList<>();

    public void createSentence(String word, List<String> words){
        setWords(words);
        setWord(word);
        words.add(word);
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public List<String> getWords() {
        return words;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(word, sentence.word) &&
                Objects.equals(words, sentence.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, words);
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "word='" + word + '\'' +
                ", words=" + words +
                '}';
    }
}

