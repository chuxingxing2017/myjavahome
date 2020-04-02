package com.itheima.dao;

import com.itheima.pojo.QueryVo;
import com.itheima.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    void insert(User user);

    void uodate(User user);

    void delect(int i);

    List<User> selectByName(String 王);

    List<User> selectByName2(String 张);

    List<User> selectByName3(QueryVo 三);

    List<User> findAllUserAccount();

}
