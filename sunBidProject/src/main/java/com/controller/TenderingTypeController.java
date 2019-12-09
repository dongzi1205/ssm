package com.controller;

import com.pojo.Tenderingtype;
import com.service.TenderingtypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TenderingTypeController {

    @Resource(name = "tenderingtypeServiceImpl")
    TenderingtypeService tenderingtypeService;

    /**
     * 前台在页面加载完毕之后通过，ajax获取招标项目的类型
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectalltenderingname")
    public List<Tenderingtype> selectAllTenderingName() {
        List<Tenderingtype> tenderingtypes = tenderingtypeService.selectAllTenderingName();
        return tenderingtypes;
    }//end  method selectAllTenderingName...

    /**
     * 查询所有的招标类型
     *
     * @return
     */
    @RequestMapping("/selecttenderingtypes")
    public ModelAndView selectTenderingTypes() {
        ModelAndView modelAndView = new ModelAndView();
        List<Tenderingtype> tenderingtypes = tenderingtypeService.selectAllTenderingName();
        modelAndView.addObject("tenderingtypes", tenderingtypes);
        modelAndView.setViewName("show_tenderingtypes");
        return modelAndView;
    }//end  method selectTenderingTypes。。。

    /**
     * 增加招标类型
     *
     * @return
     */
    @RequestMapping("/inserttenderingtype")
    public String insertTenderingType(Tenderingtype tenderingtype) {
        tenderingtypeService.insert(tenderingtype);
        return "redirect:toaddtenderingtype";
    } //end method insertTenderingType。。。。。。
}
