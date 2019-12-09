package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommoonController {

    @RequestMapping("toaddtenderprj")
    public String toAddTenderprj() {
        return "add_tenderprj";
    }

    @RequestMapping(value = "/toaddtenderingtype")
    public String toAddTenderingType() {
        return "add_tenderingtype";
    }

    @RequestMapping(value = "/verfiysuppliersignjustregister")
    public ModelAndView verfiySupplierSignJustRegister(String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", id);
        modelAndView.setViewName("verfiy_just_register");
        return modelAndView;
    }

    //财务审核完毕重定向
    @RequestMapping(value = "/verfiysuppliersignfinance")
    public ModelAndView verfiySupplierSignFinance(String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", id);
        modelAndView.setViewName("verfiy_finance");
        return modelAndView;
    }

    //增加行业信息
    @RequestMapping(value = "/inserttradettypes")
    public String insertTradetTypes() {
        return "add_tradetype";
    }

}
