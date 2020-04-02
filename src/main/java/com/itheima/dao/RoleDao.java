package com.itheima.dao;

import com.itheima.pojo.Role;

import java.util.List;

/**
 * @author Mr.CHU
 * @version 1.0
 * @description ${PACKAGE}
 * @date 2019/12/14
 */
public interface RoleDao {
    List<Role> findAllRole();

    List<Role> findAllByMany(Role role);

}
