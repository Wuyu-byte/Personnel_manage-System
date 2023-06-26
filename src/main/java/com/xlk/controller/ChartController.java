package com.xlk.controller;

import com.xlk.common.vo.DeptNumber;
import com.xlk.service.DepartmentService;
import com.xlk.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/chart")
public class ChartController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("")
    public String toEChartUI(Model model){
        return "echart/DeptNumberEchart";
    }
    @RequestMapping("/getDeptData")
    @ResponseBody
    public Map<String,Long> GetDeptNumber(){
        Map<String,Long> map=new HashMap();
        List<DeptNumber> deptNumbers = departmentService.countDeptEmployeeNumber();
        for (DeptNumber deptNumber : deptNumbers) {
            map.put(deptNumber.getName(),deptNumber.getNumber());
        }
        return map;
    }
}
