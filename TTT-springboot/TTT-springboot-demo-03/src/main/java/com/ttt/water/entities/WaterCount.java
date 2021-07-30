package com.ttt.water.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterCount {
    private String workerName;

    private String custList;

    private Integer sendWaterCount;
}
