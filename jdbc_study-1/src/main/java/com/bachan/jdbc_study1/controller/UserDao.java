package com.bachan.jdbc_study1.controller;

import com.bachan.jdbc_study1.entities.UserInfo;

import java.util.List;

/**
 * @author bachan
 * @desc
 * @date 2021/10/20
 */
public interface UserDao {
    /**
     * 添加用户
     */
    int insert(UserInfo user);

    /**
     * 根据ID删除用户
     */
    int delete(Long id);

    /**
     * 修改用户
     */
    int update(UserInfo user);

    /**
     * 根据ID查询用户
     */
    UserInfo queryById(Long id);

    /**
     * 查询所有用户
     * @return
     */
    List<UserInfo> queryAll();

    /**
     * 分页查询用户
     * @param start 开始位置
     * @param size 要查询的数据条数
     * @return
     */
    List<UserInfo> pagedQuery(int start, int size);
}
