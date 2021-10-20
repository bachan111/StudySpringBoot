package com.bachan.mybatisstudy.mapper;

import com.bachan.mybatisstudy.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author bachan
 * @desc
 * @date 2021/10/20
 */

//@Mapper : 表示本类是一个 MyBatis 的 Mapper
@Mapper
@Repository
public interface UserMapper {
    /**
     * 添加用户
     */
    int insert(User user);

    /**
     * 根据ID删除用户
     */
    int delete(Long id);

    /**
     * 修改用户
     */
    int update(User user);

    /**
     * 根据ID查询用户
     */
    User queryById(Long id);

    /**
     * 查询所有用户
     * @return
     */
    List<User> queryAll();

    /**
     * 分页查询用户
     * @param start 开始位置
     * @param size 要查询的数据条数
     * @return
     */
    List<User> pagedQuery(int start, int size);
}
