package com.xlk.service.impl;

import com.xlk.common.vo.DeptNumber;
import com.xlk.common.vo.DeptQuery;
import com.xlk.mapper.DepartmentMapper;
import com.xlk.pojo.Department;
import com.xlk.pojo.Employee;
import com.xlk.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service

public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public List<Department> queryAll() {
        return departmentMapper.queryAll();
    }

    @Override
    public Department queryById(String id) {
        return departmentMapper.queryById(id);
    }

    @Override
    public List<Employee> getDeptList(DeptQuery param) {
        return departmentMapper.getDeptList(param);
    }

    @Override
    public Long countDeptList(DeptQuery param) {
        return departmentMapper.countDeptList(param);
    }

    @Override
    public void addDept(Department department) {
        departmentMapper.addDept(department);
    }

    @Override
    public void deleteDeptById(String ids) {
        departmentMapper.deleteDeptById(ids);
    }

    @Override
    public void updateDept(Department department) {
        departmentMapper.updateDept(department);
    }

    @Override
    public List<DeptNumber> countDeptEmployeeNumber() {
        return departmentMapper.countDeptEmployeeNumber();
    }

}
