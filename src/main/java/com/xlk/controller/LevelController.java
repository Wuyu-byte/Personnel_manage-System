package com.xlk.controller;

import com.xlk.common.vo.LevelQuery;
import com.xlk.common.vo.Result;
import com.xlk.pojo.Department;
import com.xlk.pojo.Level;
import com.xlk.service.DepartmentService;
import com.xlk.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/level")
public class LevelController {
    @Autowired
    LevelService levelService;
    @Autowired
    DepartmentService departmentService;
    @GetMapping("")
    public String toLevelListUI(Model model){
        model.addAttribute("deptList",departmentService.queryAll());
        return "level/levelList";
    }

    @GetMapping("/list")
    @ResponseBody
    public Result<Object> getLevelList(LevelQuery param){
        List<Level> list=levelService.getLevelList(param);
        Long count=levelService.countLevelList(param);
        return Result.success("success",list,count);
    }

    //添加职位
    @PostMapping("/add")
    @ResponseBody
    public Result<Object> addLevel(Level level)
    {
        levelService.addLevel(level);
        return Result.success("添加职位成功");
    }
    //添加职位页面跳转
    @RequestMapping("/levelAdd")
    public String toLevelAdd(Model model){
        model.addAttribute("deptList",departmentService.queryAll());
        return "level/leveladd";
    }

    //删除部门
    @PostMapping("/delete/{ids}")
    @ResponseBody
    public Result<Object> deleteLevelById(@PathVariable("ids") String ids)
    {
        levelService.deleteLevelById(ids);
        return Result.success("删除职位成功");
    }

    //获取单个职位信息
    @GetMapping("/{id}")
    public String queryLevelById(@PathVariable("id") String id, Model model){
        model.addAttribute("level",levelService.queryById(id));
        model.addAttribute("deptList",departmentService.queryAll());
        return "level/leveledit";
    }

    //更新职位
    @RequestMapping("/update")
    @ResponseBody
    public Result<Object> updateLevel(Level level)
    {
        System.out.println(level);
        levelService.updateLevel(level);
        return Result.success("修改成功");
    }

    @RequestMapping("/queryLevelByDept")
    @ResponseBody
    public List<Level> queryLevelByDept(String department_name){
        Department department = departmentService.queryById(department_name);
        List<Level> levels = levelService.queryLevelByDept(department.getName());
        return  levels;
    }
}