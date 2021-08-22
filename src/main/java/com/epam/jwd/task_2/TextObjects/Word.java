package com.epam.jwd.task_2.TextObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Word implements Composite {

    private String word;

    private Word wordObject;

    public Word() {
        getWord();
        toString();
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
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }

    @Override
    public void getContent(List<String> list) {
        setWord(word);
        System.out.println(getWord());
    }

    public Word getWordObject() {
        return wordObject;
    }

    public void setWordObject(Word wordObject) {
        this.wordObject = wordObject;
    }
}
