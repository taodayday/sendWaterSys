package com.ttt.water.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    private String workerName;

    private Integer workerSalary;

    private double workerMoney;

    private Integer sendWorkerCount;

    private double finalSalary;
}
