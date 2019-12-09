package com.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.pojo.Tenderingprj;
import com.mapper.TenderingprjMapper;
import com.service.TenderingprjService;

import java.util.List;

@Service
public class TenderingprjServiceImpl implements TenderingprjService {

    @Resource
    private TenderingprjMapper tenderingprjMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tenderingprjMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Tenderingprj record) {
        return tenderingprjMapper.insert(record);
    }

    //查询所有的招标项目
    @Override
    public List<Tenderingprj> selectTenderingPrjs() {
        return tenderingprjMapper.selectAll();
    }

    @Override
    public int insertSelective(Tenderingprj record) {
        return tenderingprjMapper.insertSelective(record);
    }

    @Override
    public Tenderingprj selectByPrimaryKey(Integer id) {
        return tenderingprjMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Tenderingprj record) {
        return tenderingprjMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Tenderingprj record) {
        return tenderingprjMapper.updateByPrimaryKey(record);
    }

}
