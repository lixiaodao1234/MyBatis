package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author lixiaodao
 * @create 2022-04-14 - 19:50
 */
public class MBGTest {
    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询所有数据
        List<Emp> list = mapper.selectByExample(null);
        list.forEach(emp -> System.out.println(emp));
        //根据条件查询
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpNameEqualTo("张三");
        List<Emp> list1 = mapper.selectByExample(empExample);
        list1.forEach(emp-> System.out.println(emp));
    }
}
