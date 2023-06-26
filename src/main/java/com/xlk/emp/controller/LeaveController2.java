package com.xlk.emp.controller;

import com.xlk.common.util.DoubleFX;
import com.xlk.common.vo.LeaveQuery;
import com.xlk.common.vo.Result;
import com.xlk.pojo.Attendance;
import com.xlk.pojo.Employee;
import com.xlk.pojo.Leave;
import com.xlk.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/empleave")
public class LeaveController2 {

    @Autowired
    LeaveService leaveService;
    @GetMapping("")
    public String toLeaveListUI() {
        return "leave/leaveList2";
    }

    @GetMapping("/list")
    @ResponseBody//返回Json
    public Result<Object> getLeaveList(LeaveQuery param, HttpSession session) {
        Employee loginUser = (Employee) session.getAttribute("loginUser");
        param.setEmployee_name(loginUser.getName());
        List<Attendance> list = leaveService.getLeaveList(param);
        Long count = leaveService.countLeaveList(param);
        return Result.success("success", list, count);
    }

    @GetMapping("/{id}")
    public String queryLeaveById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("leave",leaveService.queryLeaveById(id));
        return "leave/leaveedit";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result<Object> updateLeave(String id,String status,String endmessage) throws ParseException {
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = time.parse(time.format(new Date()));
        Leave leave = leaveService.queryLeaveById(Integer.valueOf(id));
        leave.setStatus(Integer.parseInt(status));
        leave.setEndmessage(endmessage);
        leave.setOktime(date);
        System.out.println(leave);
        leaveService.updateLeave(leave);
        return Result.success("审批成功");
    }
    //添加部门页面跳转
    @RequestMapping("/leaveAdd")
    public String toAttendanceAdd(Model model) {
        return "leave/leaveadd";
    }
    @PostMapping("/add")
    @ResponseBody
    public Result<Object> addaAttendance(Leave leave,HttpSession session) throws ParseException {
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = time.parse(time.format(new Date()));
        Employee loginUser = (Employee) session.getAttribute("loginUser");
        leave.setEmployee_name(loginUser.getName());
        leave.setStatus(0);
        leave.setSubtime(date);
        System.out.println(leave);
        leaveService.addLeave(leave);
//        Date starttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start);
//        Date endtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end);
        return Result.success("提交申请成功");
    }

}
