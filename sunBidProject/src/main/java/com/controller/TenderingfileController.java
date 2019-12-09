package com.controller;

import com.pojo.Tenderingfile;
import com.service.TenderingfileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Controller //文件上传
public class TenderingfileController {
    //依赖于文件上传的业务层
    @Resource(name = "tenderingfileServiceImpl")
    TenderingfileService tenderingfileService;

    @ResponseBody
    @RequestMapping(value = "/uploadtenderingfiles")
    public Tenderingfile uploadTenderingFiles(@RequestParam MultipartFile uploadfiles) throws Exception {
        //上传到服务器本地
        uploadfiles.transferTo(new File("d:/fileupload/" + uploadfiles.getOriginalFilename()));
        System.out.println(uploadfiles.getOriginalFilename());
        Tenderingfile tenderingfile = new Tenderingfile();
        tenderingfile.setFilepath(uploadfiles.getOriginalFilename());
        return tenderingfile;  //返回json对象
    }//end method uploadTenderingFiles...


}
