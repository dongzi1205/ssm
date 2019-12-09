package com.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mapper.TradetypeMapper;
import com.pojo.Tradetype;
import com.service.TradetypeService;

import java.util.List;

@Service
public class TradetypeServiceImpl implements TradetypeService {

    @Resource
    private TradetypeMapper tradetypeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tradetypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Tradetype record) {
        return tradetypeMapper.insert(record);
    }

    @Override
    public int insertSelective(Tradetype record) {
        return tradetypeMapper.insertSelective(record);
    }

    @Override
    public Tradetype selectByPrimaryKey(Integer id) {
        return tradetypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Tradetype record) {
        return tradetypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Tradetype record) {
        return tradetypeMapper.updateByPrimaryKey(record);
    }

    //批量插入行业信息
    @Override
    public int insertBatchTradetypes(List<Tradetype> tradetypes) {
        return tradetypeMapper.insertBatchTradetypes(tradetypes);
    }

    //查询所有的行业类别信息
    @Override
    public List<Tradetype> selectTradetypes() {
        return tradetypeMapper.selectAll();
    }

}
