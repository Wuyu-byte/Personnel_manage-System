package com.xlk.mapper;

import com.xlk.common.vo.SalaryQuery;
import com.xlk.pojo.Salary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Mapper
@Repository
public interface SalaryMapper {
    List<Salary> getSalaryList(SalaryQuery param);

    Long countSalaryList(SalaryQuery param);

    void addSalary(Salary salary);

    void deleteSalaryById(String ids);

    Salary queryById(Integer id);

    void updateSalary(Salary salary);

}
