package com.service;

import com.pojo.City;

import java.util.List;

public interface CityService {


    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);

    City selectCityById(City city);

    City selectCityById2(int cid);

    List<City> selectAllCity(City city);

}
