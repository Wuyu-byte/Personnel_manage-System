package com.xlk.service;

import com.xlk.common.vo.DeptNumber;
import com.xlk.common.vo.DeptQuery;
import com.xlk.common.vo.EmpQuery;
import com.xlk.pojo.Department;
import com.xlk.pojo.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface DepartmentService {
    List<Department> queryAll();
    Department queryById(String id);

    List<Employee> getDeptList(DeptQuery param);

    Long countDeptList(DeptQuery param);

    void addDept(Department department);


    void deleteDeptById(String ids);

    void updateDept(Department department);

    List<DeptNumber> countDeptEmployeeNumber();

}
