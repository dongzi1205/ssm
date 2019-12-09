package com.mapper;

import com.pojo.User;
import com.pojo.UserMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMenuMapper extends Mapper<UserMenu> {

    List<UserMenu> selectUserMenuByUserRoot(User userId);
}