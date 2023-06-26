package com.xlk.emp.controller;

import com.xlk.common.vo.Result;
import com.xlk.common.vo.SalaryQuery;
import com.xlk.pojo.Employee;
import com.xlk.pojo.Salary;
import com.xlk.service.DepartmentService;
import com.xlk.service.EmployeeService;
import com.xlk.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/empsalary")
public class SalaryController2 {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    SalaryService salaryService;
    @Autowired
    DepartmentService departmentService;
    @RequestMapping("")
    public String toSalaryUi(Model model){
        return "salary/salarylist2";
    }

    @GetMapping("/list")
    @ResponseBody//返回Json
    public Result<Object> getSalaryList(SalaryQuery param, HttpSession session) {
        Employee loginUser = (Employee) session.getAttribute("loginUser");
        param.setEmployee_name(loginUser.getName());
        List<Salary> list = salaryService.getSalaryList(param);
        System.out.println(list);
        Long count = salaryService.countSalaryList(param);
        System.out.println(count);
        return Result.success("success", list, count);
    }

    //添加部门页面跳转
    @RequestMapping("/salaryAdd")
    public String toSalaryAdd(Model model) {
        model.addAttribute("deptList",departmentService.queryAll());
        return "salary/salaryadd";
    }

    @PostMapping("/add")
    @ResponseBody
    public Result<Object> addSalary(Salary salary)
    {
        if(!salary.getAd_salary().isEmpty())
        {
            String[] a=salary.getAd_salary().split("/");
            salary.setAd_salary(a[0]);
            if(a[1].equals("1"))
            {
                salary.setEnd_salary(salary.getBase_salary()+Double.valueOf(a[0]));
            }
            else
            {
                salary.setEnd_salary(salary.getBase_salary()-Double.valueOf(a[0]));
            }
        }
        else
        {
            salary.setAd_salary(String.valueOf(0));
            salary.setEnd_salary(salary.getBase_salary());
        }
        salary.setDept_name(departmentService.queryById(salary.getDept_name()).getName());
        salary.setEmployee_name(employeeService.queryEmpById(Integer.valueOf(salary.getEmployee_name())).getName());
        System.out.println(salary);
        salaryService.addSalary(salary);
        return Result.success("添加薪资成功");
    }

    @PostMapping("/delete/{ids}")
    @ResponseBody
    public Result<Object> deleteSalaryById(@PathVariable("ids") String ids)
    {
        salaryService.deleteSalaryById(ids);
        return Result.success("删除成功");
    }


}
