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
import java.util.List;

//mybatis通用接口的测试类
@Controller
public class GeneralMapperController {
    @Resource(name = "bookServiceImpl")
    BookService bookService;

    @RequestMapping(value = "/testmapper")
    public ModelAndView testMapper(@RequestParam("page") int pageNum) {
        PageHelper.startPage(pageNum, MyPage.PAGE_COUNT); //mybatis分页拦截
        //调用service的调用的通用mapper接口的方法
        List<Book> books = bookService.selectAllBooks();
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        ModelAndView modelAndView = new ModelAndView();
        //然后返回视图
        modelAndView.setViewName("forward:/index.jsp");
        //保存分页查询结果数据
        modelAndView.addObject("books", books);
        //保存分页信息
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }

    @RequestMapping(value = "/selectbookbyid")
    public ModelAndView selectBookById() {
        ModelAndView modelAndView = new ModelAndView();
        Book book = new Book();
        book.setId("1534491756793");  //传入对象根据id进行查询
        List<Book> books = bookService.selectByBookId(book);
        modelAndView.setViewName("forward:/index.jsp");
        modelAndView.addObject("books",books);
        return modelAndView;
    }

    @RequestMapping(value = "/selectbybookid2")
    public ModelAndView selectByBookId2(){
        ModelAndView modelAndView=new ModelAndView();
        Book book = new Book();
        book.setId("1534491756793");  //传入对象根据id进行查询
        Book book1 = bookService.selectBookById2(book);
        modelAndView.addObject("book",book1);
        modelAndView.setViewName("forward:/view_book.jsp");
        return modelAndView;
    }
}
