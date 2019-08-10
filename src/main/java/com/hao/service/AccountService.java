package com.hao.service;


/**
 * @Describe com.hao.service
 * @Auther wenhao chen
 * @CreateDate 2019/8/2
 * @Version 1.0
 */

public interface AccountService {
    //模拟保存账户,无参数，无返回值
    void saveAccount();

    //更新账户，有参数，无返回值
    void updataAccount(Integer i);

    //删除账户，无参数，有返回值
    int deleteAccount();
}
