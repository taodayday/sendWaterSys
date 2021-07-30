package com.ttt.water.controller;

import com.github.pagehelper.PageInfo;
import com.ttt.water.entities.Customer;
import com.ttt.water.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cust")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/custList")
    public String listCustomer(Model model){
        List<Customer> list = customerService.listCustomer();
        model.addAttribute("custList", list);
        return "custList";
    }

    @RequestMapping("/searchCustomer")
    public String searchCust(String custName, Model model) {
        List<Customer> custList = customerService.searchCustomerByName(custName);
        model.addAttribute("custList", custList);
        model.addAttribute("data",custName);
        return "custList";

    }

    @RequestMapping("/preSaveCust")
    public String saveWorkerPre() {
        return "custSave";
    }

    @RequestMapping(value="/saveCust",method = RequestMethod.POST)
    public String saveCustomer(Customer customer) {
        int rows = customerService.saveCustomer(customer);
        return "redirect:/cust/custList";
    }

    @RequestMapping("/deleteCust/{cid}")
    public String deleteCustomer(@PathVariable("cid") Integer cid) {
        Integer rows = customerService.deleteCustomer(cid);
        System.out.println("deleteCustomer rows = "+rows);
        return "redirect:/cust/custList";
    }

    @RequestMapping("/preUpdateCust/{cid}")
    public String preUpdateCust(@PathVariable("cid") Integer cid,Model model) {
        // 根据id查询对应客户信息
        Customer customer = customerService.getCustomerById(cid);
        model.addAttribute("cust",customer);
        // 跳转到修改页面
        return "custUpdate";
    }


    @RequestMapping(value="/updateCust",method = RequestMethod.POST)
    public String updateCustomer(Customer customer) {
        // 修改客户信息
        int rows = customerService.updateCustomer(customer);
        // 跳转到客户列表页面
        return "redirect:/cust/custList";
    }


    @RequestMapping("/custListPage")
    public String listCustomerForPage(
            @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum, Model model) {
        // 调用业务逻辑层，获取分页数据
        PageInfo<Customer> pageInfo = customerService.listCustomerForPage(pageNum);
        // 获取当前页的客户列表
        List<Customer> custList = pageInfo.getList();
        // 客户列表、分页对象传入前端页面
        model.addAttribute("custList",custList);
        model.addAttribute("pageInfo",pageInfo);
        // 表示普通的分页查询，不是根据条件搜索
        model.addAttribute("pageData","listCustomer");
        return "custList";
    }

    /**
     * 搜索分页
     * 步骤：
     * 1 调  客户管理的搜索功能
     * 2 转
     *   将搜索的客户列表返回给前端(数据共享)
     *   跳转到客户列表页面
     * @param custName
     * @param model
     * @return
     */
    @RequestMapping("/searchCust")
    public String searchCustomer(
            String custName,
            @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
            Model model) {
        PageInfo<Customer> pageInfo = customerService.searchCustomer(pageNum,custName);
        // 数据传入到前端
        model.addAttribute("custList",pageInfo.getList());
        model.addAttribute("pageInfo",pageInfo);
        // 按条件搜索分页查询
        model.addAttribute("pageData","searchData");
        model.addAttribute("data",custName);

        // 跳转到客户列表页面
        return "custList";
    }



}
