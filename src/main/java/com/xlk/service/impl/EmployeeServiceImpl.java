package com.xlk.service.impl;

import com.xlk.common.vo.EmpQuery;
import com.xlk.mapper.EmployeeMapper;
import com.xlk.pojo.Employee;
import com.xlk.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> getEmpList(EmpQuery param) {

        return employeeMapper.getEmpList(param);
    }

    @Override
    public Long countEmpList(EmpQuery param) {
        return employeeMapper.countEmpList(param);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public void deleteEmpById(String ids) {
        employeeMapper.deleteEmpById(ids);
    }

    @Override
    public Employee queryEmpById(Integer id) {
        return employeeMapper.queryEmpById(id);
    }

    @Override
    public void updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
    }

    @Override
    public List<Employee> queryAll() {
        return employeeMapper.queryAll();
    }

    @Override
    public List<Employee> queryEmpByDeptId(Integer dept_id) {
        return employeeMapper.queryEmpByDeptId(dept_id);
    }

    @Override
    public Employee login(Employee param) {
        return employeeMapper.login(param);
    }

    @Override
    public void updatePassword(Employee loginUser) {
        employeeMapper.updatePassword(loginUser);
    }
}
