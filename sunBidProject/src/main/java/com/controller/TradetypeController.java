package com.controller;

import com.pojo.Tradetype;
import com.service.TradetypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TradetypeController {

    @Resource(name = "tradetypeServiceImpl")
    TradetypeService tradetypeService;

    /**
     * 查询所有的行业类别的信息
     *
     * @return
     */
    @RequestMapping(value = "/selecttradetypes")
    public ModelAndView selectTradetypes() {
        List<Tradetype> tradetypes = tradetypeService.selectTradetypes();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tradetypes", tradetypes);
        modelAndView.setViewName("show_tradetypes");
        return modelAndView;
    }

    /**
     * 增加行业信息
     *
     * @return
     */
    @RequestMapping(value = "/insertbatchtradetypes")
    public ModelAndView insertBatchTradetypes(String[] tradetypename) {
        ModelAndView modelAndView = new ModelAndView();
        List<Tradetype> list = new ArrayList<>();
        //
        //将参数设置到对象中后，然后将对象添加到集合中
        for (int i = 0; i < tradetypename.length; i++) {
            Tradetype tradetype = new Tradetype();
            tradetype.setTradetypename(tradetypename[i]);
            list.add(tradetype);
        }
        //批量添加
        tradetypeService.insertBatchTradetypes(list);
        modelAndView.setViewName("redirect:inserttradettypes");
        return modelAndView;
    }


}
