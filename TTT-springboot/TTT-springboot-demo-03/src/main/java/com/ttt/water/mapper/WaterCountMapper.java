package com.ttt.water.mapper;

import com.ttt.water.entities.WaterCount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WaterCountMapper {
    List<WaterCount> listWaterCount();

    List<WaterCount> searchWaterCountByName(@Param("workerName") String workerName);
}
