package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lixiaodao
 * @create 2022-04-13 - 15:20
 */
public interface ParameterMapper {

    /**
     * 验证登录(使用@Param)
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

    /**
     * 添加用户信息
     */
    int insertUser(User user);

    /**
     * 验证登录（参数map）
     */
    User checkLoginByMap(Map<String,Object> map);

    /**
     * 验证登录
     */
    User checkLogin(String username,String password);

    /**
     * 根据用户名查询用户信息
     */
    User getUserByUsername(String username);

    /**
     * 查询所有员工信息
     */
    List<User> getAllUser();

}
