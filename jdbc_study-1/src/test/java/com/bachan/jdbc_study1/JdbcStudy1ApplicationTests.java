package com.bachan.jdbc_study1;

import com.alibaba.druid.pool.DruidDataSource;
import com.bachan.jdbc_study1.controller.impl.UserDaoImpl;
import com.bachan.jdbc_study1.entities.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class JdbcStudy1ApplicationTests {

    /**
     * Spring Boot 默认提供了数据源，默认提供了 org.springframework.jdbc.core.JdbcTemplate
     * JdbcTemplate 中会自己注入数据源，用于简化 JDBC操作
     * 还能避免一些常见的错误,使用起来也不用再自己来关闭数据库连接
     */
    @Autowired
    DataSource dataSource;

    @Autowired
    UserDaoImpl userDaoImpl;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        connection.close();
    }

    @Test
    void insertUser() {
        for (int i = 0; i < 20; i++) {
            userDaoImpl.insert(new UserInfo("tom" + i, (21 + i)));
        }
    }

    @Test
    void deleteUser() {
        long id = 2;
        userDaoImpl.delete(id);
    }

    @Test
    public void testQueryAll(){
        List<UserInfo> list = userDaoImpl.queryAll();
        System.out.println(list);
    }

    @Test
    public void testPagedQuery(){
        List<UserInfo> list = userDaoImpl.pagedQuery(1, 2);
        System.out.println(list);
    }

}
