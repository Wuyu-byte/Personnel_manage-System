package com.xlk.controller;

import com.xlk.common.vo.Result;
import com.xlk.common.vo.SalaryQuery;
import com.xlk.pojo.Reward;
import com.xlk.pojo.Salary;
import com.xlk.service.DepartmentService;
import com.xlk.service.EmployeeService;
import com.xlk.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    SalaryService salaryService;
    @Autowired
    DepartmentService departmentService;
    @RequestMapping("")
    public String toSalaryUi(Model model){
        return "salary/salarylist";
    }

    @GetMapping("/list")
    @ResponseBody//返回Json
    public Result<Object> getSalaryList(SalaryQuery param) {
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

    @GetMapping("/{id}")
    public String queryAttendanceById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("salary", salaryService.queryById(id));
        return "salary/salaryedit";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result<Object> updateSalary(Salary salary)
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
        System.out.println(salary);
        salaryService.updateSalary(salary);
        return Result.success("修改成功");
    }


}
