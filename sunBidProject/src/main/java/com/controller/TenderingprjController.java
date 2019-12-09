package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Tenderingfile;
import com.pojo.Tenderingprj;
import com.pojo.User;
import com.service.TenderingfileService;
import com.service.TenderingprjService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TenderingprjController {

    @Resource(name = "tenderingprjServiceImpl")
    TenderingprjService tenderingprjService;
    @Resource(name = "tenderingfileServiceImpl")
    TenderingfileService tenderingfileService;

    //增加招标项目
    @RequestMapping(value = "/inserttenderingproj")
    public String insertTenderingProj(HttpSession session, Tenderingprj tenderingprj, String[] upfilespath) {
        User user = (User) session.getAttribute("user");   //在session中获取当前用户
        tenderingprj.setUserid(user.getId());  //设置招标的用户id
        tenderingprj.setSign(0);  //设置招标状态默认是0
        tenderingprjService.insert(tenderingprj);  //插入招标项目，并且能够获取到回写的tenderingprj主键id
        //
        if (upfilespath != null) { //保存招标附件的路径，并批量上传到数据库
            List<Tenderingfile> tenderingfiles = new ArrayList<>();
            for (String filepath : upfilespath) {
                Tenderingfile tenderingfile = new Tenderingfile();
                tenderingfile.setFilepath(filepath);
                tenderingfile.setTenderingprjid(tenderingprj.getId());  //主键回写，使附件关联到招标项目的id
                tenderingfiles.add(tenderingfile);
            }
            //将集合批量插入到数据库中，一个招标项目对应的多个附件
            tenderingfileService.insertBatchTenderingfiles(tenderingfiles);

        }
        return "redirect:toaddtenderprj";  //重定向
    } //end  method  insertTenderingProj。。。。

    //查询所有的招标项目
    @RequestMapping(value = "/selecttenderingprojs")
    public ModelAndView selectTenderingProjs(@RequestParam(defaultValue = "1") int pageNum) {
        PageHelper.startPage(pageNum, 2); //mybatis分页助手
        List<Tenderingprj> tenderingprjs = tenderingprjService.selectTenderingPrjs();
        PageInfo pageInfo = new PageInfo(tenderingprjs);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.addObject("tenderingprjs", tenderingprjs);
        modelAndView.setViewName("show_tenderingprojs");

        return modelAndView;
    }//end method  selectTenderingProjs。。。

}
