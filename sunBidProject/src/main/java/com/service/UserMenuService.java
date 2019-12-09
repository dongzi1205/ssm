package com.service;

import com.pojo.User;
import com.pojo.UserMenu;

import java.util.List;

public interface UserMenuService{


    int deleteByPrimaryKey(Integer id);

    int insert(UserMenu record);

    int insertSelective(UserMenu record);

    UserMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserMenu record);

    int updateByPrimaryKey(UserMenu record);

    List<UserMenu> selectUserMenuByUserRoot(User userId);

}
