package com.ttt.water.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ttt.water.entities.Customer;
import com.ttt.water.mapper.CustomerMapper;
import com.ttt.water.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> listCustomer() {
        return customerMapper.listCustomer();
    }

    @Override
    public List<Customer> searchCustomerByName(String custName) {
        return customerMapper.searchCustomerByName(custName);
    }

    @Override
    public int saveCustomer( Customer customer){
        return customerMapper.saveCustomer(customer);
    }

    @Override
    public Integer deleteCustomer(Integer cid) {
        return customerMapper.deleteCustomer(cid);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    /**
     * 根据客户id查询客户信息
     *
     * @param cid 客户id
     * @return 客户信息
     */
    @Override
    public Customer getCustomerById(Integer cid) {
        return customerMapper.getCustomerById(cid);
    }

    @Override
    public PageInfo<Customer> listCustomerForPage(Integer pageNum ) {
        // 分页的核心：从第pageNum页开始，每页显示3条记录
        PageHelper.startPage(pageNum,3);
        List<Customer> list = this.listCustomer();
        // 分页Bean，封装了分页查询的数据，将查询结果注入到分页对象(Bean)
        PageInfo<Customer> pageInfo =  new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 表单搜索分页
     * @param pageNum 当前页码
     * @param custName 客户名称
     * @return 分页对象
     */
    @Override
    public PageInfo<Customer> searchCustomer(Integer pageNum, String custName) {
        PageHelper.startPage(pageNum,3);
        List<Customer> custList = this.searchCustomerByName(custName);
        PageInfo<Customer> pageInfo = new PageInfo<>(custList);
        return pageInfo;
    }


}
