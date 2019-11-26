package com.common;

import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyPage {

    public static int PAGE_COUNT;  //分页每页的条数
    public static int PAGE_PARMA;  //无实际意义的一个属性，就是看看
    public static String PAGE_MAN;  //分页的人，无实际意义的参数，就是看看
    private static Properties properties = null;

    static {
        init(); //初始化加载属性文件mybatis-pageinfo.dz
        getAllValue();  //调用类的使用直接就将全部的属性值加载到属性中去
    }

    //初始化属性文件
    private static void init() {
        try {
            properties = new Properties();
            InputStream in = Resources.getResourceAsStream("mybatis-pageinfo.dz");
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //加载所有的值，给到静态的属性
    private static void getAllValue() {
        if (properties == null) {
            init();
        }
        PAGE_COUNT = Integer.parseInt(properties.getProperty("pageCount"));
        PAGE_PARMA = Integer.parseInt(properties.getProperty("pageParma"));
        PAGE_MAN = properties.getProperty("pageMan");
    }

    public static void main(String[] args) {
        //测试：使用类名获取静态的属性
        System.out.println(MyPage.PAGE_COUNT);
        System.out.println(MyPage.PAGE_PARMA);
        System.out.println(MyPage.PAGE_MAN);
    }
}
