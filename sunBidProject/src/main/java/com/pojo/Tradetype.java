package com.pojo;

import javax.persistence.Id;

public class Tradetype {
    @Id
    private Integer id;

    /**
    * 行业类别
    */
    private String tradetypename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradetypename() {
        return tradetypename;
    }

    public void setTradetypename(String tradetypename) {
        this.tradetypename = tradetypename;
    }
}