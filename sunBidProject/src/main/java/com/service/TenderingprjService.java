package com.service;

import com.pojo.Tenderingprj;

import java.util.List;

public interface TenderingprjService{


    int deleteByPrimaryKey(Integer id);

    int insert(Tenderingprj record);

    int insertSelective(Tenderingprj record);

    Tenderingprj selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tenderingprj record);

    int updateByPrimaryKey(Tenderingprj record);
    //查询所有的招标项目
    List<Tenderingprj> selectTenderingPrjs();

}
