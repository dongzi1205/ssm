package com.controller;

import com.google.gson.Gson;
import com.pojo.User;
import com.pojo.UserMenu;
import com.service.UserMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserMenuController {

    @Resource(name = "userMenuServiceImpl")
    UserMenuService userMenuService;

    @RequestMapping(value = "/showusermenu")
    public ModelAndView selectUserMenuByUserRoot(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        System.out.println("进入到selectUserMenuByUserRoot这里面来了...");
        //User user = new User();
        //获取session作用域中的user
        User user = (User) session.getAttribute("user");
        //查询对用用户的权限树，菜单
        List<UserMenu> userMenus = userMenuService.selectUserMenuByUserRoot(user);
        Gson gson = new Gson();
        String userMenuJsonString = gson.toJson(userMenus);
        userMenuJsonString = userMenuJsonString.replaceAll("\"pid\"", "\"pId\"");
        //打印：userMenuJsonString:::[{"id":1,"pId":"0","name":"父节点","url":"https://www.baidu.com","target":"mainiframe","open":"true","isParent":"true"}
        System.out.println("userMenuJsonString:::" + userMenuJsonString);
        modelAndView.addObject("userMenuJsonString", userMenuJsonString);
        return modelAndView;
    }
}
