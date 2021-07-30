package com.ttt.water.controller;

import com.ttt.water.entities.Account;
import com.ttt.water.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/preUpdatePassword")
    public String preUpdatePassword(String userName, Model model){
        Account account =accountService.getAccountByName(userName);
        System.out.println(account+"--------------------------------------------------------");
        model.addAttribute("account",account);
        return "updatePassword";
    }

    @RequestMapping( value = "/updatePassword",method = RequestMethod.POST)
    @ResponseBody
    public String updatePassword(@RequestParam("userName")String userName, @RequestParam("userPwd")String userPwd) {
        // 修改客户信息
        Account account =accountService.getAccountByName(userName);
        account.setUserPwd(userPwd);
        System.out.println(account);
        int rows = accountService.updateProfile(account);
        if (rows>0){
            return "OK";
        } else {
            return "fail";
        }
    }
}
