package com.ttt.water.service.impl;

import com.ttt.water.entities.WaterCount;
import com.ttt.water.mapper.WaterCountMapper;
import com.ttt.water.service.WaterCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterCountServiceImpl implements WaterCountService {
    @Autowired
    private WaterCountMapper waterCountMapper;

    @Override
    public List<WaterCount> listWaterCount() {
        return waterCountMapper.listWaterCount();
    }

    @Override
    public List<WaterCount> searchWaterCountByName(String workerName){
        return waterCountMapper.searchWaterCountByName(workerName);
    }
}
