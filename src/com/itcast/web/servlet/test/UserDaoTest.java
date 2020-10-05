package com.itcast.web.servlet.test;

import com.itcast.web.servlet.dao.UserDao;
import com.itcast.web.servlet.domain.User;

public class UserDaoTest {


    public static void main(String[] args) {
        User loginUser = new User();
        loginUser.setPassword("123456");
        loginUser.setUsername("张三");
        UserDao userDao = new UserDao();
        User login = userDao.login(loginUser);
        System.out.println(login);
    }

}


