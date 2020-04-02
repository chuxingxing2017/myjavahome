package com.itheima.pojo;

import java.util.List;

/**
 * @author Mr.CHU
 * @version 1.0
 * @description ${PACKAGE}
 * @date 2019/12/14
 */
public class Role {
    private String rolename;
    private Integer id;
    private String roleDesc;
    private List<Integer> ids;
    @Override
    public String toString() {
        return "Role{" +
                "rolename='" + rolename + '\'' +
                ", id=" + id +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
