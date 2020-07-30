package com.cimo.test;

import com.cimo.dao.AccountDao;
import com.cimo.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ths
 * @create 2020/7/31 1:13
 */
public class MybatisTest {

    @Test
    public void run1() throws IOException {

        //加载配置文件
        InputStream in = Resources.getResourceAsStream("MybatisConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);
        //查询所有
        List<Account> list = accountDao.findAll();
        System.out.println(list.toString());
        //关闭和释放资源
        session.close();
        in.close();

    }

    @Test
    public void run2() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("MybatisConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);
        //保存
        Account account = new Account();
        account.setName("殷伟伟");
        account.setMoney(123d);
        accountDao.saveAccount(account);
        //提交事务
        session.commit();
        //关闭和释放资源
        session.close();
        in.close();
    }

}
