package com.atguigu.mybatis.test;


import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author lixiaodao
 * @create 2022-04-13 - 21:07
 */
public class SelectMapperTest {

    /**
     * MyBatis的各种查询功能：
     * 1、若查询出数据只有一条
     * a>可以通过实体类对象接收
     * b>可以通过List集合接收
     * c>可以通过map集合接收
     * 结果{password=123456, sex=女, id=1, age=23, email=1234@qq.com, username=admin}
     * 2、若查询的数据有多条，
     * a>可以通过List集合接收
     * b>可以通过Map类型的List集合接收
     * c>可以在mapper接口的方法上添加@MapKey注解，
     * 此时就可以将每条数据转换的map集合作为值，以某个字段的值作为键，放在同一个map集合中
     *
     * 注意：一定不能通过实体类对象接收，此时会抛出TooManyResultsException
     *
     * 在MyBatis中，对于Java中常用的类型都设置了类型别名
     * 例如：java.lang.Integer-->int|integer
     * 例如：int-->_int|_integer
     * 例如：Map-->map,List-->list
     */
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(1));
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUser());
    }
    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToMap(1));

    }

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());

    }
}
