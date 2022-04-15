package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lixiaodao
 * @create 2022-04-14 - 20:12
 */
public class PageHelperTest {
    /**
     * limit index,pagesize
     * index:当前页的起始索引
     * pageSize：每页显示的条目数
     * pageNum:当前页的页码
     * index=(pageNum-1)*pageSize
     *
     * 使用MyBatis的分页插件实现分页功能
     * 1、需要在查询功能之前开启分页
     * PageHelper.startPage(int pageNum,int pageSize);
     */
    @Test
    public void testPageHelper(){
        EmpMapper mapper = null;
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            mapper = sqlSession.getMapper(EmpMapper.class);
            //访问第一页，每页四条数据
            //Page<Object> page = PageHelper.startPage(1, 4);
            PageHelper.startPage(1, 4);
            List<Emp> list = mapper.selectByExample(null);
            PageInfo<Emp> page = new PageInfo<>(list,5);
            //emps.forEach(System.out::println);
            System.out.println(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
