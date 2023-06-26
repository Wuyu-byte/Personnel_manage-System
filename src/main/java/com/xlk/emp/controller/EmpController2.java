package com.xlk.emp.controller;

import com.xlk.common.util.EmpUid;
import com.xlk.common.vo.EmpQuery;
import com.xlk.common.vo.Result;
import com.xlk.pojo.Department;
import com.xlk.pojo.Employee;
import com.xlk.pojo.Level;
import com.xlk.service.DepartmentService;
import com.xlk.service.EmployeeService;
import com.xlk.service.LevelService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emp2")
public class EmpController2 {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    LevelService levelService;

    //员工UI显示
    @GetMapping("")
    public String toEmpListUI(){
        return "emp/emptable2";
    }
    //添加员工页面跳转
    @RequestMapping("/empAdd")
    public String toEmpAdd(Model model){
        List<Department> deptList=departmentService.queryAll();
        List<Level> levelList=levelService.queryAll();
        model.addAttribute("levelList",levelList);
        model.addAttribute("deptList",deptList);
        return "emp/empadd";
    }
    //查询员工
    @GetMapping("/list")
    @ResponseBody//返回Json
    public Result<Object> getEmpList(EmpQuery param){
        List<Employee> list=employeeService.getEmpList(param);
        Long count=employeeService.countEmpList(param);
        return Result.success("success",list,count);
    }

    //获取单个员工信息
    @GetMapping("/{id}")
    public String queryEmpById(@PathVariable("id") Integer id,Model model){
        //获取部门信息和级别信息
        List<Department> deptList=departmentService.queryAll();
        List<Level> levelList=levelService.queryAll();
        model.addAttribute("levelList",levelList);
        model.addAttribute("deptList",deptList);
        //获取员工信息
        Employee employee = employeeService.queryEmpById(id);
        model.addAttribute("emp",employee);
        return "emp/empedit";
    }

}
