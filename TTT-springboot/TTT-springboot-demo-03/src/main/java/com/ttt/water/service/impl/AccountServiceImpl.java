package com.ttt.water.service.impl;

import com.ttt.water.entities.Account;
import com.ttt.water.mapper.AccountMapper;
import com.ttt.water.service.AccountService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;


    @Override
    public boolean login(@Param("userName") String userName, @Param("userPwd") String userPwd) {
        Account account = accountMapper.login(userName,userPwd);
        if (null ==account){
            return false;
        }

        if(Objects.equals(userPwd,account.getUserPwd())){
            return true;
        }
        return false;
    }

    @Override
    public int updateProfile(Account account){
        return accountMapper.updateProfile(account);
    }

    @Override
    public Account getAccountByName(String userName){
        return accountMapper.getAccountByName(userName);
    }

}
