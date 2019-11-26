package com.pojo;

import lombok.Data;
import javax.persistence.Id;



public class City {
    @Id
    private Integer id;

    private String cityname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
}