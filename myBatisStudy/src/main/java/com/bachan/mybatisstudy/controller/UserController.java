package com.bachan.mybatisstudy.controller;

import com.bachan.mybatisstudy.entities.User;
import com.bachan.mybatisstudy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bachan
 * @desc
 * @date 2021/10/20
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/addUser")
    public String insert(User user) {
        userMapper.insert(user);
        return "insert";
    }

    @GetMapping("/delUser")
    public String delete(Long id) {
        userMapper.delete(id);
        return "delUser";
    }

    @GetMapping("/updateUser")
    public String update(User user) {
        userMapper.update(user);
        return "update";
    }

    @GetMapping("/queryUser")
    public User queryById(Long id) {
        return userMapper.queryById(id);
    }

    @GetMapping("/queryAll")
    public List<User> queryAll() {
        String sql = "select * from t_user";
        return userMapper.queryAll();
    }
}
