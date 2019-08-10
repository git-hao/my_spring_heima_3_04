package com;

import com.hao.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Describe test
 * @Auther wenhao chen
 * @CreateDate 2019/8/10
 * @Version 1.0
 *
 *
 */
public class AOPtest {
    public static void main(String[] args) {
        //1、获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、获取对象
        AccountService as = (AccountService) ac.getBean("accountService");
        //3、执行方法
        as.saveAccount();
    }
}
