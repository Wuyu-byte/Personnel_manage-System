package com.xlk.controller;

import com.xlk.common.util.EmpUid;
import com.xlk.common.vo.DeptQuery;
import com.xlk.common.vo.EmpQuery;
import com.xlk.common.vo.Result;
import com.xlk.pojo.Department;
import com.xlk.pojo.Employee;
import com.xlk.pojo.Level;
import com.xlk.service.DepartmentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dept")
@Controller
public class DeptController {

    @Autowired
    DepartmentService departmentService;
    @GetMapping("")
    public String toDeptListUI(){
        return "dept/deptList";
    }

    @GetMapping("/list")
    @ResponseBody//返回Json
    public Result<Object> getDeptList(DeptQuery param){
        List<Employee> list=departmentService.getDeptList(param);
        Long count=departmentService.countDeptList(param);
        return Result.success("success",list,count);
    }

    //添加部门
    @PostMapping("/add")
    @ResponseBody
    public Result<Object> addDept(Department department)
    {
        System.out.println(department);
        departmentService.addDept(department);
        return Result.success("添加部门成功");
    }
    //添加部门页面跳转
    @RequestMapping("/deptAdd")
    public String toDeptAdd(){
        return "dept/deptadd";
    }

    //删除部门
    @PostMapping("/delete/{ids}")
    @ResponseBody
    public Result<Object> deleteDeptById(@PathVariable("ids") String ids)
    {
        departmentService.deleteDeptById(ids);
        return Result.success("删除部门成功");
    }



    //获取单个部门信息
    @GetMapping("/{id}")
    public String queryDeptById(@PathVariable("id") String id,Model model){
        model.addAttribute("dept",departmentService.queryById(id));
        return "dept/deptedit";
    }


    //更新部门
    @RequestMapping("/update")
    @ResponseBody
    public Result<Object> updateDept(Department department)
    {
        System.out.println(department);
        departmentService.updateDept(department);
        return Result.success("修改成功");
    }
}
