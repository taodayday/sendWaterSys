package com.ttt.water.mapper;

import com.ttt.water.entities.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {

    List<Customer> listCustomer();

    List<Customer> searchCustomerByName(@Param("custName") String custName);

    int saveCustomer( Customer customer);

    Integer deleteCustomer(Integer cid);

    int updateCustomer(Customer customer);

    Customer getCustomerById(Integer cid);

}
