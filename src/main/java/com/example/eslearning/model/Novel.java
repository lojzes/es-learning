package com.example.eslearning.model;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/7/18 0018 16:28
 */
public class Novel {

    private String title;
    private String author;
    private String publishDate;
    private int wordCount;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }
}
