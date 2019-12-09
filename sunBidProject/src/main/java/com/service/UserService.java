package com.service;

import com.pojo.User;
public interface UserService{


    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户名密码检查用户的登陆
     * @param user
     * @return
     */
    User userLoginByUsernameAndUserPassword(User user);

    int testMapperInsert(User user);

}
