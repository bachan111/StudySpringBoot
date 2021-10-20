package com.bachan.jdbc_study1.controller.impl;

import com.bachan.jdbc_study1.controller.UserDao;
import com.bachan.jdbc_study1.entities.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bachan
 * @desc
 * @date 2021/10/20
 */

@Service
public class UserDaoImpl implements UserDao {

    /**
     * Spring Boot 默认提供了数据源，默认提供了 org.springframework.jdbc.core.JdbcTemplate
     * JdbcTemplate 中会自己注入数据源，用于简化 JDBC操作
     * 还能避免一些常见的错误,使用起来也不用再自己来关闭数据库连接
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(UserInfo user) {
        String sql = "insert into t_user(name,age) values(?,?)";
        return jdbcTemplate.update(sql,user.getName(),user.getAge());
    }

    @Override
    public int delete(Long id) {
        String sql = "delete from t_user where id = ?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int update(UserInfo user) {
        String sql = "update t_user set name = ?,age = ? where id = ?";
        return jdbcTemplate.update(sql,user.getName(),user.getAge(),user.getId());
    }

    @Override
    public UserInfo queryById(Long id) {
        String sql = "select * from t_user where id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
    }

    @Override
    public List<UserInfo> queryAll() {
        String sql = "select * from t_user";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(UserInfo.class));
    }

    @Override
    public List<UserInfo> pagedQuery(int start, int size) {
        String sql = "select * from t_user limit ?,?";
        return jdbcTemplate.query(sql,new Object[]{start,size},new BeanPropertyRowMapper<>(UserInfo.class));
    }
}
