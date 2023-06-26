package com.xlk.controller;

import com.xlk.common.util.EmpUid;
import com.xlk.common.vo.EmpQuery;
import com.xlk.common.vo.Result;
import com.xlk.pojo.Department;
import com.xlk.pojo.Employee;
import com.xlk.pojo.Level;
import com.xlk.pojo.User;
import com.xlk.service.DepartmentService;
import com.xlk.service.EmployeeService;
import com.xlk.service.LevelService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    LevelService levelService;

    //员工UI显示
    @GetMapping("")
    public String toEmpListUI(){
        return "emp/emptable";
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
    //添加员工
    @PostMapping("/add")
    @ResponseBody
    public Result<Object> addEmp(Employee employee,String dept_id,String level_id)
    {
        employee.setEmployee_id(EmpUid.getID());
        employee.setDepartment(departmentService.queryById(dept_id));
        employee.setLevel(levelService.queryById(level_id));
        employeeService.addEmployee(employee);
        return Result.success("添加员工成功");
    }
    //删除员工
    @PostMapping("/delete/{ids}")
    @ResponseBody
    public Result<Object> deleteEmpById(@PathVariable("ids") String ids)
    {
        employeeService.deleteEmpById(ids);
        return Result.success("删除员工成功");
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

    //更新员工
    @RequestMapping("/update")
    @ResponseBody
    public Result<Object> updateEmp(Employee employee,@Param("department.id") String dept_id,String level_id)
    {
        employee.setDepartment(departmentService.queryById(dept_id));
        employee.setLevel(levelService.queryById(level_id));
        employeeService.updateEmp(employee);
        return Result.success("修改成功");
    }

    @RequestMapping("/queryEmpByDept")
    @ResponseBody
    public List<Employee> queryEmpByDept(String dept_id){
        List<Employee> employeeList = employeeService.queryEmpByDeptId(Integer.valueOf(dept_id));
        System.out.println(employeeList);
        return employeeList;
    }


    @RequestMapping("/updateEmpPassword")
    @ResponseBody
    public Result<Object> updatePassword(HttpSession session, String old_password, String new_password, String again_password){
        Employee loginUser = (Employee) session.getAttribute("loginUser");
        //验证密码
        boolean matches =old_password.equals(loginUser.getPassword());
        if(matches)
        {
            if(new_password.equals(again_password))
            {
                loginUser.setPassword(new_password);
                employeeService.updatePassword(loginUser);
                return Result.success("修改密码成功");
            }
            else
            {
                return Result.fail("二次重复密码不一致");
            }
        }
        return Result.success("老密码错误");
    }

}
