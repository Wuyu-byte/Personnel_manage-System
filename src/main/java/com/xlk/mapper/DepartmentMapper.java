package com.xlk.mapper;

import com.xlk.common.vo.DeptNumber;
import com.xlk.common.vo.DeptQuery;
import com.xlk.pojo.Department;
import com.xlk.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface DepartmentMapper {
    Department queryById(String id);
    List<Department> queryAll();

    List<Employee> getDeptList(DeptQuery param);

    Long countDeptList(DeptQuery param);

    void addDept(Department department);

    void deleteDeptById(String ids);

    void updateDept(Department department);

    List<DeptNumber> countDeptEmployeeNumber();

}
