package com.xlk.service;

import com.xlk.common.vo.SalaryQuery;
import com.xlk.pojo.Salary;

import java.util.List;

public interface SalaryService {

    List<Salary> getSalaryList(SalaryQuery param);

    Long countSalaryList(SalaryQuery param);

    void addSalary(Salary salary);

    void deleteSalaryById(String ids);

    Salary queryById(Integer id);

    void updateSalary(Salary salary);

}
