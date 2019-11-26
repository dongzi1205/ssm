package com.pojo;

import javax.persistence.*;

@Table(name = "cart")
public class Cart {
    @Id
    @Column(name = "cartid")
    @GeneratedValue(generator = "JDBC")
    private Integer cartid;

    @Column(name = "bookid")
    private String bookid;

    @Column(name = "booknum")
    private Integer booknum;

    /**
     * @return cartid
     */
    public Integer getCartid() {
        return cartid;
    }

    /**
     * @param cartid
     */
    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    /**
     * @return bookid
     */
    public String getBookid() {
        return bookid;
    }

    /**
     * @param bookid
     */
    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    /**
     * @return booknum
     */
    public Integer getBooknum() {
        return booknum;
    }

    /**
     * @param booknum
     */
    public void setBooknum(Integer booknum) {
        this.booknum = booknum;
    }
}