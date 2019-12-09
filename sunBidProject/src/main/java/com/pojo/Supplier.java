package com.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Supplier {
    @Id
    private Integer id;
    @Column(name = "supplier_name")
    private String supplierName;
    @Column(name = "supplier_people")
    private String supplierPeople;
    @Column(name = "supplier_money")
    private Integer supplierMoney;
    @Column(name = "supplier_address")
    private String supplierAddress;
    @Column(name = "supplier_tel")
    private String supplierTel;
    @Column(name = "supplier_sign")
    private Integer supplierSign;
    @Column(name = "explains")
    private String explains;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierPeople() {
        return supplierPeople;
    }

    public void setSupplierPeople(String supplierPeople) {
        this.supplierPeople = supplierPeople;
    }

    public Integer getSupplierMoney() {
        return supplierMoney;
    }

    public void setSupplierMoney(Integer supplierMoney) {
        this.supplierMoney = supplierMoney;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierTel() {
        return supplierTel;
    }

    public void setSupplierTel(String supplierTel) {
        this.supplierTel = supplierTel;
    }

    public Integer getSupplierSign() {
        return supplierSign;
    }

    public void setSupplierSign(Integer supplierSign) {
        this.supplierSign = supplierSign;
    }

    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains;
    }
}