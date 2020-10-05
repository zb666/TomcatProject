package com.itcast.web.servlet.dao;

import com.itcast.web.servlet.domain.User;
import com.itcast.web.servlet.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    public User login(User loginUser) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
