package com.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    /**
     * 删除一个用户并且修改一个用户
     * 调用多个mapper层的接口
     */
    //开启事务，并指定事务的传播方式，不指定默认也是这个。
    //而且开启事务之后在当前的业务逻辑之中，所有的操作要么都成功，要么都失败
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void delAndUpdate(int id, User user) {
        userMapper.deleteByPrimaryKey(id);  //删除一个
        //在中间模拟一个错误，当出错的时候，因为开启事务，会自动回滚，不会出现
        //一个提交另一个确没有执行的尴尬问题。。。
        // Integer.parseInt("a");
        userMapper.updateByPrimaryKey(user);  //修改一个
    }

}
