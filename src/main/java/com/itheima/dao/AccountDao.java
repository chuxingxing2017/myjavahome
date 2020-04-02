package com.itheima.dao;

import com.itheima.pojo.Account;

import java.util.List;

/**
 * @author Mr.CHU
 * @version 1.0
 * @description ${PACKAGE}
 * @date 2019/12/14
 */
public interface AccountDao {
    List<Account> findAllAccountUser();

}
