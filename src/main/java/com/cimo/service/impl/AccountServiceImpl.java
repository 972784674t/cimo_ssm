package com.cimo.service.impl;

import com.cimo.dao.AccountDao;
import com.cimo.domain.Account;
import com.cimo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ths
 * @create 2020/7/30 23:35
 */

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("Service:查询所有账户信息");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("Service:保存账户");
        accountDao.saveAccount(account);
    }

    @Override
    public void transfer(String name1,double money,String name2){

        System.out.println("Service:转账 -> 事务控制测试");

        //转入账户减钱
        Account account1 = accountDao.findAccountByName(name1);
        account1.setMoney(account1.getMoney()-money);

        //转出账户加钱
        Account account2 = accountDao.findAccountByName(name2);
        account2.setMoney(account2.getMoney()+money);

        accountDao.updateAccount(account1);

        int i = 1/0;

        accountDao.updateAccount(account2);

    }

}
