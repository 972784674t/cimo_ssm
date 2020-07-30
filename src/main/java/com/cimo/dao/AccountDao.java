package com.cimo.dao;

import com.cimo.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ths
 * @create 2020/7/30 23:32
 */

@Repository
public interface AccountDao {

    /**
     * 查询所有账户信息
     * @return 账户列表
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 通过账户名获取账户信息
     * @param name 账户名
     * @return 账户信息
     */
    @Select("select * from account where name=#{name}")
    Account findAccountByName(@Param("name") String name);

    /**
     * 保存账户信息
     * @param account 账户信息
     */
    @Insert("insert into account (name,money) values (#{name},#{money})")
    void saveAccount(Account account);

    /**
     * 更改账户信息
     * @param account 账户信息
     */
    @Update("update account set money=#{money} where name=#{name}")
    void updateAccount(Account account);

}
