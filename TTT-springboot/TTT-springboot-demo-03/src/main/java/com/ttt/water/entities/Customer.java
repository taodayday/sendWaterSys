package com.ttt.water.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author caojie
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Integer cid;

    private String custName;

    private String custMobile;

    private String custAddress;

    private Integer custTicket;


}
