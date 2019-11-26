package com.controller;

import com.pojo.Book;
import com.pojo.City;
import com.service.BookService;
import com.service.CityService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.List;

@Controller
public class AnnoIdController {
    @Resource(name = "cityServiceImpl")
    CityService cityService;

    @Autowired
    BookService bookService;

    //ok
    //使用cityMapper.selectByPrimaryKey(city);查询，，，City,,id-->Integer
    @RequestMapping(value = "/selectcitybyidforkey")
    public ModelAndView selectCityById() {
        ModelAndView modelAndView = new ModelAndView();
        City city = new City();
        city.setId(11);
        City city1 = cityService.selectCityById(city);
        modelAndView.addObject("city1", city1);
        modelAndView.setViewName("forward:/view_book.jsp");
        return modelAndView;
    }

    // ok
    //使用cityMapper.select(city);查询，，，City
    @RequestMapping(value = "/selectallcitybyid")
    public ModelAndView selectCityById2() {
        ModelAndView modelAndView = new ModelAndView();
        City city = new City();
        city.setId(11);
        List<City> cities = cityService.selectAllCity(city);
        modelAndView.setViewName("forward:/index.jsp");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    //ok
    //使用bookMapper.select(book);查询，，，Book
    @RequestMapping(value = "/selectallbookbyid")
    public ModelAndView selectBookById() {
        ModelAndView modelAndView = new ModelAndView();
        Book book = new Book();
        book.setId("1534491756793");  //传入对象根据id进行查询
        List<Book> books = bookService.selectByBookId(book);
        modelAndView.setViewName("forward:/index.jsp");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    //no
    //使用bookMapper.selectByPrimaryKey(book);查询，，，Book，，，id->String
    @RequestMapping(value = "/selectbookbyidforkey")
    public ModelAndView selectByBookId2() {
        ModelAndView modelAndView = new ModelAndView();
        Book book = new Book();
        book.setId("1534491756793");  //传入对象根据id进行查询
        Book book1 = bookService.selectBookById2(book);
        modelAndView.addObject("book", book1);
        modelAndView.setViewName("forward:/view_book.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/str")
    public ModelAndView selectByBookId3() {
        ModelAndView modelAndView = new ModelAndView();
        Book book1 = bookService.selectBookById3("1534491756793");
        modelAndView.addObject("book", book1);
        modelAndView.setViewName("forward:/view_book.jsp");
        return modelAndView;
    }

    //ok----根据int  cid  key
    @RequestMapping(value = "/test11")
    public ModelAndView test1() {
        ModelAndView modelAndView = new ModelAndView();
        City city = cityService.selectCityById2(11);
        modelAndView.addObject("city1", city);
        modelAndView.setViewName("forward:/view_book.jsp");
        return modelAndView;
    }

}
