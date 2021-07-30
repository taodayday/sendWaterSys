package com.ttt.water.service;

import com.github.pagehelper.PageInfo;
import com.ttt.water.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> listCustomer();

    List<Customer> searchCustomerByName(String custName);

    int saveCustomer( Customer customer);

    Integer deleteCustomer(Integer cid);

    int updateCustomer(Customer customer);

    Customer getCustomerById(Integer cid);

    public final static int PAGE_SiZE = 3;

    public PageInfo<Customer> listCustomerForPage(Integer pageNum );

    /**
     * 表单搜索分页
     * @param pageNum 当前页码
     * @param custName 客户名称
     * @return 分页对象
     */
    PageInfo<Customer> searchCustomer(Integer pageNum,String custName);
}
