package com.itcast.web.servlet.web;

import com.itcast.web.servlet.dao.UserDao;
import com.itcast.web.servlet.domain.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserDao userDao = new UserDao();
        User loginUser = userDao.login(user);
        if (loginUser != null) {
            //存储数据 重定向转发
            //域对象
            req.setAttribute("user",user);
            req.getRequestDispatcher("/successServlet").forward(req, resp);
        } else {
            //登录失败
            req.getRequestDispatcher("/failServlet").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
