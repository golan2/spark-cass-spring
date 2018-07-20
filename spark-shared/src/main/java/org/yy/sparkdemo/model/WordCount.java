package org.yy.sparkdemo.model;

import java.io.Serializable;

public class WordCount implements Serializable {

    private static final long serialVersionUID = -6686669703226702589L;
    private String word;
    private int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
