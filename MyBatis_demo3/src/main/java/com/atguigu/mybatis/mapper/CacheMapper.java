package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author lixiaodao
 * @create 2022-04-14 - 17:18
 */
public interface CacheMapper {
    Emp getEmpByEid(@Param("eid") Integer id);

    void InsertEmp(Emp emp);
}
