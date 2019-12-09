package com.service;

import com.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mapper.UserMenuMapper;
import com.pojo.UserMenu;
import com.service.UserMenuService;

import java.util.List;

@Service
public class UserMenuServiceImpl implements UserMenuService {

    @Resource
    private UserMenuMapper userMenuMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserMenu record) {
        return userMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(UserMenu record) {
        return userMenuMapper.insertSelective(record);
    }

    @Override
    public UserMenu selectByPrimaryKey(Integer id) {
        return userMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserMenu record) {
        return userMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserMenu record) {
        return userMenuMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<UserMenu> selectUserMenuByUserRoot(User userId) {
        return userMenuMapper.selectUserMenuByUserRoot(userId);
    }

}
