package com.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mapper.TenderingfileMapper;
import com.pojo.Tenderingfile;
import com.service.TenderingfileService;

import java.util.List;

@Service
public class TenderingfileServiceImpl implements TenderingfileService {

    @Resource
    private TenderingfileMapper tenderingfileMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tenderingfileMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Tenderingfile record) {
        return tenderingfileMapper.insert(record);
    }

    @Override
    public int insertSelective(Tenderingfile record) {
        return tenderingfileMapper.insertSelective(record);
    }

    @Override
    public Tenderingfile selectByPrimaryKey(Integer id) {
        return tenderingfileMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Tenderingfile record) {
        return tenderingfileMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Tenderingfile record) {
        return tenderingfileMapper.updateByPrimaryKey(record);
    }

    //批量上传招标附件的方法
    @Override
    public int insertBatchTenderingfiles(List<Tenderingfile> tenderingfiles) {
        return tenderingfileMapper.insertTenderingfiles(tenderingfiles);
    }

}
