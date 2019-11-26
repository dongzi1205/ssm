package com.test;

import com.pojo.User;
import com.service.UserService;
import com.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userServiceImpl", UserServiceImpl.class);
        User user = userService.selectByPrimaryKey(1);
        System.out.println(user.getUsername());
    }
}
