package com.ttt.water.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * TODO
 *
 * @author caojie
 * @version 1.0
 * @date 2021/7/24 9:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class History {
    /**
     * 送水历史编号
     */
    private Integer hid;
    /**
     * 送水历史关联了工人信息
     */
    private Worker worker;

    /**
     * 使用年月日的格式显示送水时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sendWaterTime;
    /**
     * 历史表关联了客户信息
     */
    private Customer customer;
    /**
     * 送水数量
     */
    private Integer sendWaterCount;
}
