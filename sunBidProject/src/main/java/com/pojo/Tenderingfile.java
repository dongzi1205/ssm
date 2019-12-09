package com.pojo;

import javax.persistence.Id;

public class Tenderingfile {
    @Id
    private Integer id;

    /**
    * 招标项目编号
    */
    private Integer tenderingprjid;

    /**
    * 招标文件
    */
    private String filepath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTenderingprjid() {
        return tenderingprjid;
    }

    public void setTenderingprjid(Integer tenderingprjid) {
        this.tenderingprjid = tenderingprjid;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}