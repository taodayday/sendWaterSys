package com.ttt.water.service.impl;

import com.ttt.water.entities.Salary;
import com.ttt.water.mapper.SalaryMapper;
import com.ttt.water.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public List<Salary> listSalary() {
        return salaryMapper.listSalary();
    }
}
