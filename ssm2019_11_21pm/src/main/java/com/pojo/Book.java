package com.pojo;

import lombok.Data;

import javax.persistence.Id;

public class Book {
    @Id
    private String id;

    private String bookname;

    private String bookauthor;

    private String bookbz;

    private String bookimg;

    private Integer bookprice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getBookbz() {
        return bookbz;
    }

    public void setBookbz(String bookbz) {
        this.bookbz = bookbz;
    }

    public String getBookimg() {
        return bookimg;
    }

    public void setBookimg(String bookimg) {
        this.bookimg = bookimg;
    }

    public Integer getBookprice() {
        return bookprice;
    }

    public void setBookprice(Integer bookprice) {
        this.bookprice = bookprice;
    }
}