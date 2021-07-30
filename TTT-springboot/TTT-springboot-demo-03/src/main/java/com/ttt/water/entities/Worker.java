package com.ttt.water.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    private Integer wid;

    private String workerName;

    private Integer workerSalary;

    private double workerMoney;

    private String workerImage;
}
