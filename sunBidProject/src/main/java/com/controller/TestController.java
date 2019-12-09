package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class TestController {
    @Resource(name = "userServiceImpl")
    UserService userService;

    @RequestMapping("testmapperinserthuixie")
    public void testMapperInsertHuiXie() {
        User user = new User();
        user.setUserName("yyy");
        user.setUserPassWord("1234");
        userService.testMapperInsert(user);
        System.out.println("测试mapper通用接口回写主键：" + user.getId());
    }
}
