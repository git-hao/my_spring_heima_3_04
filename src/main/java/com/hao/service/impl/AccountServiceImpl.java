package com.hao.service.impl;

import com.hao.service.AccountService;

/**
 * @Describe com.hao.service.impl
 * @Auther wenhao chen
 * @CreateDate 2019/8/10
 * @Version 1.0
 */
public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        //异常通知验证
        //int i = 1/0;
        System.out.println("保存成功");
    }

    public void updataAccount(Integer i) {
        System.out.println("更新成功"+i);
    }

    public int deleteAccount() {
        System.out.println("删除成功");
        return 0;
    }
}
