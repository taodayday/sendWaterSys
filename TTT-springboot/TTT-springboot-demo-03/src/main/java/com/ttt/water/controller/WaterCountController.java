package com.ttt.water.controller;

import com.ttt.water.entities.WaterCount;
import com.ttt.water.service.WaterCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/waterCount")
public class WaterCountController {
    @Autowired
    private WaterCountService waterCountService;

    @RequestMapping("/waterCountList")
    public String listWaterCount(Model model){
        List<WaterCount> list = waterCountService.listWaterCount();
        model.addAttribute("waterCountList", list);
        return "waterCountList";
    }

    @RequestMapping("/searchWaterCount")
    public String searchWaterCount(String workerName,Model model){
        List<WaterCount> list = waterCountService.searchWaterCountByName(workerName);
        model.addAttribute("waterCountList",list);
        model.addAttribute("data",workerName);
        return "/waterCountList";
    }
}
