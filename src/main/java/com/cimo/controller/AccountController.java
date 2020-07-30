package com.cimo.controller;

import com.cimo.domain.Account;
import com.cimo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ths
 * @create 2020/7/30 23:36
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("controller:查询所有账户信息");
        List<Account> accountList = accountService.findAll();
        model.addAttribute("list",accountList);
        System.out.println(accountList);
        return "list";
    }

    @RequestMapping("/save")
    public void saveAccount(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("controller:保存账户信息");
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }

    @RequestMapping("/transfer")
    public void transfer(@RequestParam("name1") String name1, @RequestParam("money") double money, @RequestParam("name2") String name2,
    HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("controller:转账 -> 测试事务控制");
        accountService.transfer(name1,money,name2);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }

}
