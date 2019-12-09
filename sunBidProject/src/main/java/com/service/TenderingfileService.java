package com.service;

import com.pojo.Tenderingfile;

import java.util.List;

public interface TenderingfileService{


    int deleteByPrimaryKey(Integer id);

    int insert(Tenderingfile record);

    int insertSelective(Tenderingfile record);

    Tenderingfile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tenderingfile record);

    int updateByPrimaryKey(Tenderingfile record);

    int insertBatchTenderingfiles(List<Tenderingfile> tenderingfiles);

}
