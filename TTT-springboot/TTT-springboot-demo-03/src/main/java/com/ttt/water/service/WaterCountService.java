package com.ttt.water.service;

import com.ttt.water.entities.WaterCount;

import java.util.List;

public interface WaterCountService {
    List<WaterCount> listWaterCount();

    List<WaterCount> searchWaterCountByName(String workerName);

}
