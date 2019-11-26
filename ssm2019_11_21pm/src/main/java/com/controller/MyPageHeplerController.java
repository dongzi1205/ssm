package com.controller;

import com.common.MyPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Book;
import com.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.net.SocketTimeoutException;
import java.util.List;
//测试分页的控制层
@Controller
public class MyPageHeplerController {
    //在控制层实现将service层的对象注入
    @Resource(name = "bookServiceImpl")
    BookService bookService;

    /**
     * @param pageNum 传入参数当前页
     * @return 返回视图和分页查询结果
     */
    @RequestMapping(value = "/testpage")
    public ModelAndView test1(@RequestParam("page") int pageNum) {
        //指定两个参数，当前页数和每页的条数（每一页需要显示的条数从配置文件中获取）
        //PageHelper.startPage写在查询语句的上面，使用mybatis拦截方式实现分页
        //PageHelper.startPage必须是在一个查询语句的上面而且紧邻
        //这里的MyPage类是前面自定义的获取属性文件里面值的类
        PageHelper.startPage(pageNum, MyPage.PAGE_COUNT);
        //查询全部结果方法
        List<Book> books = bookService.selectAllBooks();
        //这是一个获取分页信息的对象，在这里可以指定泛型，也可以不指定
        //将获取分页的集合传到这里，就是上面的分页后的集合（books）
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        System.err.println("pageInfo分页信息对象:" + pageInfo);
        System.out.println("当前页：" + pageInfo.getPageNum());
        System.out.println("显示条数：" + pageInfo.getSize());
        System.out.println("第几行开始：" + pageInfo.getStartRow());
        System.out.println("第几行结束：" + pageInfo.getEndRow());
        System.out.println("数据总条数：" + pageInfo.getTotal());
        System.out.println("分页总页数：" + pageInfo.getPages());
        System.out.println("getNavigatepageNums数组中的第一个数：" + pageInfo.getFirstPage());
        System.out.println("上一页：" + pageInfo.getPrePage());
        System.out.println("下一页：" + pageInfo.getNextPage());
        System.out.println("最后一页：" + pageInfo.getLastPage());
        int[] nums = pageInfo.getNavigatepageNums(); //获取页码
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");  //打印所有的页码
        }
        System.out.println("");
        //创建视图模型对象，设置返回的视图和分页的结果
        ModelAndView modelAndView = new ModelAndView();
        //将页面信息pageInfo传到jsp页面,使用对象获取里面的属性
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.addObject("books", books);
        modelAndView.setViewName("forward:/index.jsp");
        return modelAndView;
    }
}
