package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Controller
public class UserController {
    // @Autowired
    @Resource(name = "userServiceImpl")
    UserService userService;

    @RequestMapping(value = "/userlogin")
    public ModelAndView userLoginByUsernameAndUserPassword(HttpSession session, User user, String userVerification) {
        System.out.println("进入到userLoginByUsernameAndUserPassword了...");
        //判断验证码是否正确，如果不正确返回登陆页面继续登陆
        String randomNum = (String) session.getAttribute("randomNum");
        ModelAndView modelAndView = new ModelAndView();
        if (randomNum.equals(userVerification)) {
            //验证码正确，继续执行登陆操作
            User u = userService.userLoginByUsernameAndUserPassword(user);
            //如果用户存在，重定向页面到权限菜单显示的controller下面
            if (u != null) {
                System.out.println(u.toString());
                //将登陆的用户保存到session作用域
                session.setAttribute("user", u);
                modelAndView.setViewName("redirect:/showusermenu");
            } else {
                //如果用户不存在，重定向页面到登陆页面
                modelAndView.addObject("message", "用户名或密码错误！");
                modelAndView.setViewName("redirect:/userlogin.jsp");
            }
        } else {
            //验证码不正确
            modelAndView.setViewName("redirect:/userlogin.jsp");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/userverification")
    public void userVerificationCode(HttpSession session, HttpServletResponse response) {
        BufferedImage bufferedImage = new BufferedImage(50, 20,
                BufferedImage.TYPE_INT_RGB);// 创建内存图像
        Graphics graphics = bufferedImage.getGraphics();// 获取图形上下文
        graphics.setColor(Color.RED);// 设置背景颜色
        // graphics.fillRect(0, 0, backWidth, backHeight);

        // 字体大小为图片高度的80%
        int fx = (int) (14 * 0.2);// 第一个字符左边起始方间距
        int fy = 14;// 字符的上面的间距
        graphics.setFont(new Font("Default", Font.ITALIC, 14));// 设定字体
        //随机数生成验证码
        Random random = new Random();
        int randomNum = random.nextInt(9000) + 1000;  //生成1000---8999的随机四位数
        //绘制验证码的图片
        graphics.drawString(randomNum + "", fx, fy);
        //将验证码保存到session中去
        session.setAttribute("randomNum", randomNum + "");
        //关闭graphics的使用
        graphics.dispose();
        System.out.println("进入到验证码方法里面来了....");
        try {
            //写文件，到浏览器---> response.getOutputStream()
            ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

