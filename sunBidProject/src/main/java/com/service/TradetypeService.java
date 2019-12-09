package com.service;

import com.pojo.Tradetype;

import java.util.List;

public interface TradetypeService{


    int deleteByPrimaryKey(Integer id);

    int insert(Tradetype record);

    int insertSelective(Tradetype record);

    Tradetype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tradetype record);

    int updateByPrimaryKey(Tradetype record);

    List<Tradetype> selectTradetypes();

    int insertBatchTradetypes(List<Tradetype> tradetypes);

}
