package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.pojo.Account;
import com.itheima.pojo.QueryVo;
import com.itheima.pojo.Role;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class MybatisTest {

    private InputStream in;
    private UserDao userDao;
    private SqlSession sqlSession;
    private AccountDao accountDao;
    private RoleDao roleDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(in);
        sqlSession = sessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
        accountDao = sqlSession.getMapper(AccountDao.class);
        roleDao = sqlSession.getMapper(RoleDao.class);
    }
    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    //查询所有
    @Test
    public void fun(){
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    //添加用户
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("张三丰");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("武当山");
        userDao.insert(user);
        System.out.println(user);
    }

    //修改用户信息
    @Test
    public void update(){
        User user = new User();
        user.setUid(10);
        user.setUsername("张翠山");
        user.setAddress("武当山大堂");
        user.setBirthday(new Date());
        user.setSex("男");
        userDao.uodate(user);
    }
    //删除用户信息
    @Test
    public void delect(){
        userDao.delect(9);
    }

    //模糊查询(username)  #{}
    @Test
    public void selectByName(){
        List<User> list = userDao.selectByName("三");
        list.forEach(System.out::println);
    }
    //模糊查询2   ${}
    @Test
    public void selectByName2(){
        List<User> list = userDao.selectByName2("张");
        list.forEach(System.out::println);
    }

    //模糊查询3   复杂类属性  QueryVo  -> User
    @Test
    public void selectByName3(){
        User user = new User();
        user.setUsername("三");
        QueryVo vo = new QueryVo();
        vo.setUser(user);
        List<User> myuser = userDao.selectByName3(vo);
        System.out.println(myuser);
    }

    /**
    * @Description: 一个user对应多个account账户,查询所有用户信息
    * @Param: []
    * @return: void
    * @Author: Mr.Wang
    * @Date: 2019/12/14
    */

    @Test
    public void findAllUserAccount(){
        List<User> userList = userDao.findAllUserAccount();
        userList.forEach(System.out::println);
    }

    /**
    * @Description: 一个account对应一个user账户,查询所有用户信息
    * @Param: []
    * @return: void
    * @Author: Mr.Wang
    * @Date: 2019/12/14
    */
    @Test
    public void findAllAccountUser(){
        List<Account> accountList = accountDao.findAllAccountUser();
        accountList.forEach(System.out::println);
    }

    /**
    * @Description: 查询所有角色表信息
    * @Param: []
    * @return: void
    * @Author: Mr.Wang
    * @Date: 2019/12/14
    */
    @Test
    public void funAllRole(){
        List<Role> roleList = roleDao.findAllRole();
        roleList.forEach(System.out::println);
    }

    @Test
    public void findAllByMany(){
        Role role = new Role();
        ArrayList<Integer> ids = new ArrayList<>();
        Collections.addAll(ids, 1, 2);
        role.setRolename("长");
        role.setIds(ids);
        List<Role> roleList = roleDao.findAllByMany(role);
        roleList.forEach(System.out::println);
    }

}
