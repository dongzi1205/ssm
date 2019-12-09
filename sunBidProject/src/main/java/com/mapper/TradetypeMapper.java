package com.mapper;

import com.pojo.Tradetype;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TradetypeMapper extends Mapper<Tradetype> {
    int insertBatchTradetypes(List<Tradetype> tradetypes);
}