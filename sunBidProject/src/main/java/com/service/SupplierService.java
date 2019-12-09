package com.service;

import com.pojo.Supplier;

import java.util.List;

public interface SupplierService {


    int deleteByPrimaryKey(Integer id);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

    List<Supplier> selectSupplierJustRegisterNoVerify(Supplier supplier);

    List<Supplier> selectOneVerifySupplier(Supplier supplier);

    List<Supplier> selectNotPassSupplier(Supplier supplier);

    List<Supplier> selectBlacklistSupplier(Supplier supplier);

    List<Supplier> selectOkFinanceSupplier(Supplier supplier);

    List<Supplier> selectNotPassFinanceSupplier(Supplier supplier);
    //采购员审核，1
    int updateSupplierByParamKey(Supplier supplier);

}
