package com.ttt.water.controller;

import cn.hutool.core.util.StrUtil;
import com.ttt.water.entities.Worker;
import com.ttt.water.service.WorkerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    @RequestMapping("/workerList")
    public String listCustomer(Model model){
        List<Worker> list = workerService.listWorker();
        model.addAttribute("workerList", list);
        return "workerList";
    }

    @RequestMapping("/searchWorker")
    public String searchWorker(String workerName, Model model) {
        List<Worker> workerList = workerService.searchWorkerByName(workerName);
        model.addAttribute("workerList", workerList);
        model.addAttribute("data",workerName);
        return "workerList";
    }

    @Value("${location}")
    private String location;


    @RequestMapping("/preSaveWorker")
    public String saveWorkerPre() {
        return "workerSave";
    }

    @RequestMapping(value="/saveWorker",method = RequestMethod.POST)
    public String saveWorker(Worker worker, MultipartFile fileUpload) throws IOException {

        String originalFilename = fileUpload.getOriginalFilename();
        if (StrUtil.isNotEmpty(fileUpload.getOriginalFilename())) {
            // 系统当前时间作为文件前缀
            int suffixIndex = originalFilename.lastIndexOf(".");
            long prefix = System.currentTimeMillis();
            // 获取浏览器上传文件的后缀
            String suffix = originalFilename.substring(suffixIndex);
            // 重新组装上传文件的名称，例如：16765656541.jpg
            String fullFileName = prefix + suffix;
            // 创建上传文件服务器路径
            File parentPath = new File(location);
            // 条件成立：服务器路径不存在创建路径
            if (!parentPath.exists()) {
                parentPath.mkdirs();
            }
            // 文件上传的目的路径
            File destPath = new File(parentPath,fullFileName);
            // 上传文件
            fileUpload.transferTo(destPath);
            worker.setWorkerImage(fullFileName);
        }


        int rows = workerService.saveWorker(worker);
        return "redirect:/worker/workerList";
    }

    @RequestMapping("/deleteWorker/{wid}")
    public String deleteWorker(@PathVariable("wid") Integer wid) {
        Integer rows = workerService.deleteWorker(wid);
        System.out.println("deleteWorker rows = "+rows);
        return "redirect:/worker/workerList";
    }


    @RequestMapping(value="/adjustSalary",method = RequestMethod.POST)
    @ResponseBody
    public String adjustSalary(Integer wid,Integer workerSalary){
        int rows = workerService.adjustSalary(wid, workerSalary);
        if (rows > 0) {
            return "success";
        } else{
            return "fail";
        }
    }


}
