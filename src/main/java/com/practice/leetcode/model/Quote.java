package com.practice.leetcode.model;

public class Quote {
    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return authorName;
    }

    public void setAuthor(String authorName) {
        this.authorName = authorName;
    }

    public Quote(String quote, String authorName){
        this.quote = quote;
        this.authorName = authorName;
    }

    String quote;
    String authorName;
}
