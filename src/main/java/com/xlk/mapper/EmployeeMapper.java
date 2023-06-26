package com.xlk.mapper;

import com.xlk.common.vo.EmpQuery;
import com.xlk.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmployeeMapper {

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
