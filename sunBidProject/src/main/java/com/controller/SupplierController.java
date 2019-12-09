package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Supplier;
import com.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SupplierController {
    @Resource(name = "supplierServiceImpl")
    SupplierService supplierService;

    /**
     * 刚刚注册的供应商，还没有进行任何审核
     *
     * @return
     */
    @RequestMapping(value = "/selectsupplierjustregisternoverify")
    public ModelAndView selectSupplierJustRegisterNoVerify(@RequestParam(defaultValue = "1") int pageNum) {
        Supplier supplier = new Supplier();
        supplier.setSupplierSign(0); //待采购员进行审计的标号是 0
        PageHelper.startPage(pageNum, 2);
        List<Supplier> suppliers = supplierService.selectSupplierJustRegisterNoVerify(supplier);
        PageInfo pageInfo = new PageInfo(suppliers);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("suppliers", suppliers);
        modelAndView.addObject("pageInfo", pageInfo);
        System.out.println(pageInfo);
        modelAndView.setViewName("show_supplier_just_register");
        return modelAndView;
    }

    /**
     * 采购员审核通过的供应商：1
     *
     * @return
     */
    @RequestMapping(value = "/selectoneverifysupplier")
    public ModelAndView selectOneVerifySupplier(@RequestParam(defaultValue = "1") int pageNum) {
        Supplier supplier = new Supplier();
        supplier.setSupplierSign(1);
        PageHelper.startPage(pageNum, 2);  //分页插件
        List<Supplier> suppliers = supplierService.selectOneVerifySupplier(supplier);
        PageInfo pageInfo = new PageInfo(suppliers);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("suppliers", suppliers);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("show_one_verify_supplier");
        return modelAndView;
    }

    /**
     * 财务待审核的供应商：1
     *
     * @return
     */
    @RequestMapping(value = "/selectfinanceverifysupplier")
    public ModelAndView selectFinanceVerifySupplier(@RequestParam(defaultValue = "1") int pageNum) {
        Supplier supplier = new Supplier();
        supplier.setSupplierSign(1);
        PageHelper.startPage(pageNum, 2);  //分页插件
        List<Supplier> suppliers = supplierService.selectOneVerifySupplier(supplier);
        PageInfo pageInfo = new PageInfo(suppliers);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("suppliers", suppliers);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("show_supplier_caiwu_verify");
        return modelAndView;
    }
    /**
     * 查询未通过采购员的供应商：2
     *
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/selectnotpasssupplier")
    public ModelAndView selectNotPassSupplier(@RequestParam(defaultValue = "1") int pageNum) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("show_not_pass_supplier");
        Supplier supplier = new Supplier();
        supplier.setSupplierSign(2);
        PageHelper.startPage(pageNum, 2);
        List<Supplier> suppliers = supplierService.selectNotPassSupplier(supplier);
        PageInfo pageInfo = new PageInfo(suppliers);
        modelAndView.addObject("suppliers", suppliers);
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }

    /**
     * 查询黑名单供应商：5
     *
     * @return
     */
    @RequestMapping(value = "/selectblacklistsupplier")
    public ModelAndView selectBlacklistSupplier(@RequestParam(defaultValue = "1") int pageNum) {
        ModelAndView modelAndView = new ModelAndView();
        Supplier supplier = new Supplier();
        supplier.setSupplierSign(5);
        PageHelper.startPage(pageNum, 2);
        List<Supplier> suppliers = supplierService.selectBlacklistSupplier(supplier);
        PageInfo pageInfo = new PageInfo(suppliers);
        modelAndView.addObject("suppliers", suppliers);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("show_blacklist_supplier");
        return modelAndView;
    }

    /**
     * 财务审核通过的供应商，这时候已经是投标成功的供应商了。
     *
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/selectokfinancesupplier")
    public ModelAndView selectOkFinanceSupplier(@RequestParam(defaultValue = "1") int pageNum) {
        ModelAndView modelAndView = new ModelAndView();
        Supplier supplier = new Supplier();
        supplier.setSupplierSign(3);
        PageHelper.startPage(pageNum, 2);
        List<Supplier> suppliers = supplierService.selectOkFinanceSupplier(supplier);
        PageInfo pageInfo = new PageInfo(suppliers);
        modelAndView.addObject("suppliers", suppliers);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("show_ok_finance_supplier");
        return modelAndView;
    }

    /**
     * 财务审核未通过的供应商
     *
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/selectnotpassfinancesupplier")
    public ModelAndView selectNotPassFinanceSupplier(@RequestParam(defaultValue = "1") int pageNum) {
        ModelAndView modelAndView = new ModelAndView();
        Supplier supplier = new Supplier();
        supplier.setSupplierSign(4);
        PageHelper.startPage(pageNum, 2);
        List<Supplier> suppliers = supplierService.selectNotPassFinanceSupplier(supplier);
        PageInfo pageInfo = new PageInfo(suppliers);
        modelAndView.addObject("suppliers", suppliers);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("show_not_pass_finance_supplier");
        return modelAndView;
    }
    //审核

    /**
     * 采购员审核刚刚注册的供应商：sign更改为：1 2 5
     *
     * @param supplier
     * @return
     */
    @RequestMapping(value = "/updateverfiysignById")
    public String updateVerfiySignById(Supplier supplier) {
        supplierService.updateSupplierByParamKey(supplier);
        return "redirect:selectsupplierjustregisternoverify";
    }
    /**
     * 财务的供应商：sign更改为：3 4 5
     *
     * @param supplier
     * @return
     */
    @RequestMapping(value = "/updatefinanceverfiysignbyId")
    public String updateFinanceVerfiySignById(Supplier supplier) {
        supplierService.updateSupplierByParamKey(supplier);
        return "redirect:verfiysuppliersignfinance";
    }
}
