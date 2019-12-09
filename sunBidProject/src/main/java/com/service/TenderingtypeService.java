package com.service;

import com.pojo.Tenderingprj;
import com.pojo.Tenderingtype;

import java.util.List;

public interface TenderingtypeService {


    int deleteByPrimaryKey(Integer id);

    int insert(Tenderingtype record);

    int insertSelective(Tenderingtype record);

    Tenderingtype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tenderingtype record);

    int updateByPrimaryKey(Tenderingtype record);

    List<Tenderingtype> selectAllTenderingName();




}
