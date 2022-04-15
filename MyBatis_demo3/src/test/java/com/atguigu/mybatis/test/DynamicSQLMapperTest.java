package com.atguigu.mybatis.test;


import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author lixiaodao
 * @create 2022-04-14 - 15:40
 */
public class DynamicSQLMapperTest {
    /**
     * 1.if:根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到SQL中
     * 2，where:
     * 当where标签中有内容时，会自动生成where关键字，并将内容前多余的and和or去掉
     * 当where标签中没有内容时，此时where标签没有任何效果
     */
    @Test
    public void testGetEmpCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, "张三", null, "男", "123@qq.com"));
        System.out.println(list);
    }

    @Test
    public void getEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByChoose(new Emp(null, "张三", null, "男", "null"));
        System.out.println(list);
    }

    @Test
    public void getDeleteMoreByArray() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[]{6, 7, 8, 9, 10});
        System.out.println(result);
    }

    @Test
    public void insertMoreByList() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"a",23,"男","123@321.com");
        Emp emp2 = new Emp(null,"b",23,"男","123@321.com");
        Emp emp3 = new Emp(null,"c",23,"男","123@321.com");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        int result = mapper.insertMoreByList(emps);
        System.out.println(result);
    }

}
