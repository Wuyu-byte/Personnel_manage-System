package com.xlk.service.impl;

import com.xlk.common.vo.SalaryQuery;
import com.xlk.mapper.SalaryMapper;
import com.xlk.pojo.Salary;
import com.xlk.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationDataSourceInitializer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SalaryServiceImpl implements SalaryService {
    @Autowired
    SalaryMapper salaryMapper;
    @Override
    public List<Salary> getSalaryList(SalaryQuery param) {
        return salaryMapper.getSalaryList(param);
    }
    @Override
    public Long countSalaryList(SalaryQuery param) {
        return salaryMapper.countSalaryList(param);
    }

    @Override
    public void addSalary(Salary salary) {
        salaryMapper.addSalary(salary);
    }

    @Override
    public void deleteSalaryById(String ids) {
        salaryMapper.deleteSalaryById(ids);
    }

    @Override
    public Salary queryById(Integer id) {
        return salaryMapper.queryById(id);
    }

    @Override
    public void updateSalary(Salary salary) {
        salaryMapper.updateSalary(salary);
    }
}
