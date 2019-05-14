package com.example.streaming.beans;

public class Line {
    public int getIndex() {
        return index;
    }

    public String getContent() {
        return content;
    }

    private int index;
    private String content;

    public Line(int index, String content) {
        this.index = index;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Line{" +
                "index=" + index +
                ", content='" + content + '\'' +
                '}';
    }
}
