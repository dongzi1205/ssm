package com.controller;

import com.pojo.User;
import com.service.UserService;
import com.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/mycontroller1")
public class MyController1 {
    /*
    controller层依赖注入：
        实现userServiceImpl对象的注入：相当于===>UserService userService=userServiceImpl;
                                    也就是UserService userService=new UserServiceImpl(),对象.
        userServiceImpl对象由spring核心容器来创建，而userServiceImpl所依赖的dao（mapper）层接口由
        mybatis核心配置去创建，但是MyController1对象是springmvc核心配置文件去创建的。
     */
    @Resource(name = "userServiceImpl")
    UserService userService;

    @RequestMapping("/test1")
    public String test1(Map<String, Object> map) {
        System.out.println("进入到这里面来了");
        //controller层调用service层
        User user = userService.selectByPrimaryKey(1);
        //封装结果返回 到视图页面
        map.put("user", user);
        System.out.println(user.getUsername() + "\t" + user.getPassword());
        return "aa";  //返回到aa.jsp页面
    }

    @RequestMapping(value = "/test2")
    public String test2() {
        System.out.println("进入到这里面来了test2");
        //手动加载applicationContext.xml的spring核心容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //手动调用userServiceImpl的对象
        UserService userService = context.getBean("userServiceImpl", UserServiceImpl.class);
        User user = userService.selectByPrimaryKey(1);
        System.out.println(user.getUsername() + "**********");
        return "aa";
    }

    @RequestMapping("/test3")
    public String test3() {
        System.out.println("进入到test3");
        User user = new User();
        user.setId(2);  //修改2
        user.setUsername("admin");
        user.setPassword("root");
        userService.delAndUpdate(5, user);  //删除5
        return "aa";
    }
}
