package com.itheima.pojo;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;

/**
 * @author Mr.CHU
 * @version 1.0
 * @description 账户实体类
 * @date 2019/12/14
 */
public class Account {
    private int id;
    private int uid;
    private int money;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                ", user=" + user +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
