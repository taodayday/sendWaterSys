package com.ttt.water.controller;

import com.ttt.water.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.*;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String userName, String userPwd, Model model){
        boolean loginResult = accountService.login(userName, userPwd);
        // 条件成立：登录成功，跳转到主页面
        if(loginResult){
            model.addAttribute("userName", userName);
            return "waterMainMenu";
        } else {
            model.addAttribute("loginFail","用户名或者密码错误");
            return "index";
        }
    }
}
