package com.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mapper.CityMapper;
import com.pojo.City;
import com.service.CityService;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Resource
    private CityMapper cityMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(City record) {
        return cityMapper.insert(record);
    }

    @Override
    public int insertSelective(City record) {
        return cityMapper.insertSelective(record);
    }

    @Override
    public City selectByPrimaryKey(Integer id) {
        return cityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(City record) {
        return cityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public City selectCityById2(int cid) {
        return cityMapper.selectByPrimaryKey(cid);
    }

    //根据id查询城市
    @Override
    public City selectCityById(City city) {
        return cityMapper.selectByPrimaryKey(city);
    }

    @Override
    public List<City> selectAllCity(City city) {
        return cityMapper.select(city);
    }

    @Override
    public int updateByPrimaryKey(City record) {
        return cityMapper.updateByPrimaryKey(record);
    }

}
