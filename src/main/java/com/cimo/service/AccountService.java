package com.cimo.service;

import com.cimo.domain.Account;

import java.util.List;

/**
 * @author ths
 * @create 2020/7/30 23:34
 */
public interface AccountService {

    /**
     * 查询所有账户信息
     * @return 账户列表
     */
    List<Account> findAll();

    /**
     * 保存账户信息
     * @param account 账户信息
     * @return 是否成功
     */
    void saveAccount(Account account);

    /**
     * 用户转账 -> 用于事务测试
     * @param name1 用户1
     * @param money 转账金额
     * @param name2 用户2
     */
    void transfer(String name1,double money,String name2);

}
