package com.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.pojo.Supplier;
import com.mapper.SupplierMapper;
import com.service.SupplierService;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Resource
    private SupplierMapper supplierMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return supplierMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Supplier record) {
        return supplierMapper.insert(record);
    }

    @Override
    public int insertSelective(Supplier record) {
        return supplierMapper.insertSelective(record);
    }

    @Override
    public Supplier selectByPrimaryKey(Integer id) {
        return supplierMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Supplier record) {
        return supplierMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Supplier> selectNotPassFinanceSupplier(Supplier supplier) {
        return supplierMapper.select(supplier);
    }
    //采购员审核，1
    @Override
    public int updateSupplierByParamKey(Supplier supplier) {
        return supplierMapper.updateByPrimaryKeySelective(supplier);
    }

    @Override
    public List<Supplier> selectOkFinanceSupplier(Supplier supplier) {
        return supplierMapper.select(supplier);
    }

    @Override
    public List<Supplier> selectBlacklistSupplier(Supplier supplier) {
        return supplierMapper.select(supplier);
    }

    @Override
    public List<Supplier> selectNotPassSupplier(Supplier supplier) {
        return supplierMapper.select(supplier);
    }

    @Override
    public List<Supplier> selectOneVerifySupplier(Supplier supplier) {
        return supplierMapper.select(supplier);
    }

    @Override
    public int updateByPrimaryKey(Supplier record) {
        return supplierMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据sign审计标号，查询刚注册供应商，开始审计，标号0
     *
     * @param supplier
     * @return
     */
    @Override
    public List<Supplier> selectSupplierJustRegisterNoVerify(Supplier supplier) {
        return supplierMapper.select(supplier);
    }

}
