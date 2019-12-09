package com.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Tenderingprj {
    @Id
    @GeneratedValue(generator = "JDBC")  //主键回写的注解，记得重启呦
    private Integer id;

    /**
    * 招标类型id
    */
    private Integer tenderingtypeid;

    /**
    * 投标人
    */
    private Integer userid;

    /**
    * 投标标题
    */
    private String tenderingprjtitle;

    /**
    * 内容
    */
    private String tenderingprjbody;

    /**
    * 发布时间
    */
    private String releasetime;

    /**
    * 截止时间
    */
    private String supplierendtime;

    /**
    * 开标时间
    */
    private String opentime;

    /**
    * 中标单位
    */
    private Integer supplierid;

    /**
    * 招标状态
    */
    private Integer sign;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTenderingtypeid() {
        return tenderingtypeid;
    }

    public void setTenderingtypeid(Integer tenderingtypeid) {
        this.tenderingtypeid = tenderingtypeid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTenderingprjtitle() {
        return tenderingprjtitle;
    }

    public void setTenderingprjtitle(String tenderingprjtitle) {
        this.tenderingprjtitle = tenderingprjtitle;
    }

    public String getTenderingprjbody() {
        return tenderingprjbody;
    }

    public void setTenderingprjbody(String tenderingprjbody) {
        this.tenderingprjbody = tenderingprjbody;
    }

    public String getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(String releasetime) {
        this.releasetime = releasetime;
    }

    public String getSupplierendtime() {
        return supplierendtime;
    }

    public void setSupplierendtime(String supplierendtime) {
        this.supplierendtime = supplierendtime;
    }

    public String getOpentime() {
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime;
    }

    public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }
}