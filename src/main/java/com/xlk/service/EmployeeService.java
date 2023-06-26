package com.xlk.service;

import com.xlk.common.vo.EmpQuery;
import com.xlk.pojo.Employee;
import com.xlk.pojo.User;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmpList(EmpQuery param);

    Long countEmpList(EmpQuery param);

    void addEmployee(Employee employee);

    void deleteEmpById(String ids);

    Employee queryEmpById(Integer id);

    void updateEmp(Employee employee);

    List<Employee> queryAll();

    List<Employee> queryEmpByDeptId(Integer dept_id);


    Employee login(Employee param);

    void updatePassword(Employee loginUser);

}
