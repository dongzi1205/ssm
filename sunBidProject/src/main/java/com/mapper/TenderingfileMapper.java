package com.mapper;

import com.pojo.Tenderingfile;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TenderingfileMapper extends Mapper<Tenderingfile> {
    //批量上传招标附件的方法
    int insertTenderingfiles(List<Tenderingfile> tenderingfiles);
}