package com.service;

import com.pojo.Tenderingprj;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mapper.TenderingtypeMapper;
import com.pojo.Tenderingtype;

import java.util.List;

@Service
public class TenderingtypeServiceImpl implements TenderingtypeService{

    @Resource
    private TenderingtypeMapper tenderingtypeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tenderingtypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Tenderingtype record) {
        return tenderingtypeMapper.insert(record);
    }

    @Override
    public int insertSelective(Tenderingtype record) {
        return tenderingtypeMapper.insertSelective(record);
    }

    @Override
    public Tenderingtype selectByPrimaryKey(Integer id) {
        return tenderingtypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Tenderingtype record) {
        return tenderingtypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Tenderingtype record) {
        return tenderingtypeMapper.updateByPrimaryKey(record);
    }



    @Override
    public List<Tenderingtype> selectAllTenderingName() {
        return tenderingtypeMapper.selectAll();
    }

}
