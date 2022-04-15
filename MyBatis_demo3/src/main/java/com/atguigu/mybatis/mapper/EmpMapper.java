package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lixiaodao
 * @create 2022-04-13 - 23:06
 */
public interface EmpMapper {
    /**
     * 查询所有员工信息
     */
    List<Emp> getAllEmp();

    /**
     * 查询员工以及员工所对应的部门信息
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);

    /**
     * 通过分布查询查询员工以及员工所对应的部门信息
     * 分布查询的第一步：查询员工信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    /**
     * 通过分步查询，查询部门及对应的所有员工信息
     * 分步查询第二步：根据部门id查询部门中的所有员工
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
