package com.ttt.water.mapper;

import com.ttt.water.entities.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {


    Account login(@Param("userName") String userName, @Param("userPwd")String userPwd);

//    int updateProfile(@Param("userName") String userName,@Param("userPwd") String userPwd,@Param("userName2") String userName2);
    int updateProfile(Account account);

    Account getAccountByName(String userName);
}
