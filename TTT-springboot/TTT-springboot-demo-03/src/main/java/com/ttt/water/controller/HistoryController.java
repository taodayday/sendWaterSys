package com.ttt.water.controller;


import com.ttt.water.entities.Customer;
import com.ttt.water.entities.History;
import com.ttt.water.entities.Worker;
import com.ttt.water.service.CustomerService;
import com.ttt.water.service.HistoryService;
import com.ttt.water.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private WorkerService workerService;

    @RequestMapping("/historyList")
    public String listHistory(Model model) {
        List<History> historyList = historyService.listHistory();
        // 历史列表共享到前端页面
        model.addAttribute("historyList",historyList);
        // 跳转到送水历史列表
        return "historyList";
    }

    @RequestMapping("/preSaveHistory")
    public String saveHistoryPre(Model model) {
        List<Customer> customerList = customerService.listCustomer();
        List<Worker> workerList = workerService.listWorker();
        model.addAttribute("customerList",customerList);
        model.addAttribute("workerList",workerList);

        return "historySave";
    }

    @RequestMapping("/saveHistory")
    public String saveHistory(History history,Integer custId,Integer workerId){
        Customer customer = new Customer();
        customer.setCid(custId);
        Worker worker = new Worker();
        worker.setWid(workerId);

        history.setWorker(worker);
        history.setCustomer(customer);

        int rows = historyService.saveHistory(history);
        return "redirect:/history/historyList";
    }



    @RequestMapping("/preUpdateHistory/{hid}")
    public String preUpdateHistory(@PathVariable("hid") Integer hid, Model model) {
        History history = historyService.getHistoryById(hid);
        List<Customer> customerList = customerService.listCustomer();
        List<Worker> workerList = workerService.listWorker();
        model.addAttribute("history",history);
        model.addAttribute("customerList",customerList);
        model.addAttribute("workerList",workerList);

        return "historyUpdate";
    }

    @RequestMapping(value = "/upateHistory",method = RequestMethod.POST)
    public String updateHistory(History history,Integer custId,Integer workerId) {
        Customer customer = new Customer();
        customer.setCid(custId);
        Worker worker = new Worker();
        worker.setWid(workerId);

        history.setWorker(worker);
        history.setCustomer(customer);

        int rows = historyService.updateHistory(history);
        return "redirect:/history/historyList";
    }

    @RequestMapping("/deleteHistory/{hid}")
    public String deleteHistory(@PathVariable("hid")Integer hid){
        Integer rows = historyService.deleteHistory(hid);
        System.out.println("deletehistory rows = "+rows);
        return "redirect:/history/historyList";
    }

    @RequestMapping(value="/deleteBatch",method = RequestMethod.POST)
    @ResponseBody
    public String deleteBatchHistory(@RequestParam("ids")String ids) {
        int rows = historyService.deleteBatchHistory(ids);
        if(rows > 0) {
            return "OK";
        } else {
            return "fail";
        }
    }

}
