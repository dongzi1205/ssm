package com.pojo;

import javax.persistence.Id;

public class Tenderingtype {
    @Id
    private Integer id;

    /**
    * 招标类型
    */
    private String tenderingtypename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenderingtypename() {
        return tenderingtypename;
    }

    public void setTenderingtypename(String tenderingtypename) {
        this.tenderingtypename = tenderingtypename;
    }
}