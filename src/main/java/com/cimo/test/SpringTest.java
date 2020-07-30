package com.cimo.test;

import com.cimo.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ths
 * @create 2020/7/30 23:45
 */
public class SpringTest {

    @Test
    public void run1(){

        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取对象
        AccountService as = (AccountService) ac.getBean("accountService");
        //执行方法
        as.findAll();

    }

}
