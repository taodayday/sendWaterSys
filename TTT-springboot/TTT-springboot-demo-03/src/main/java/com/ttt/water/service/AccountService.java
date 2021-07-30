package com.ttt.water.service;

import com.ttt.water.entities.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountService {

//    boolean login(String userName, String userPwd);

    boolean login(@Param("userName")String userName,@Param("userPwd")String userPwd);

    int updateProfile(Account account);

    Account getAccountByName(String userName);

}
