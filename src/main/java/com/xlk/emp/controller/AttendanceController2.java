package com.xlk.emp.controller;

import com.xlk.common.util.DoubleFX;
import com.xlk.common.vo.AttendanceQuery;
import com.xlk.common.vo.Result;
import com.xlk.pojo.Attendance;
import com.xlk.pojo.Employee;
import com.xlk.service.AttendanceService;
import com.xlk.service.EmployeeService;
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
@RequestMapping("/empattendance")
public class AttendanceController2 {
    @Autowired
    AttendanceService attendanceService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public String toAttendanceListUI() {
        return "attendance/attendanceList2";
    }

    @GetMapping("/list")
    @ResponseBody//返回Json
    public Result<Object> getAttendanceList(AttendanceQuery param,HttpSession session) {
        Employee loginUser = (Employee) session.getAttribute("loginUser");
        param.setEmployee_name(loginUser.getName());
        List<Attendance> list = attendanceService.getAttendanceList(param);
        Long count = attendanceService.countAttendanceList(param);
        return Result.success("success", list, count);
    }

    //添加部门页面跳转
    @RequestMapping("/AttendanceAdd")
    public String toAttendanceAdd(Model model) {
        model.addAttribute("empList", employeeService.queryAll());
        return "attendance/attendanceadd";
    }

    @PostMapping("/add")
    @ResponseBody
    public Result<Object> addaAttendance(Attendance attendance, String start, String end) throws ParseException {
        Date starttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start);
        Date endtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end);
        Long time = endtime.getTime() - starttime.getTime();
        Double worktime = time / 1000.0 / 60.0 / 60.0;
        attendance.setWorktime(DoubleFX.getDoubleToString(worktime, 2));
        attendance.setStarttime(starttime);
        attendance.setEndtime(endtime);
        attendanceService.addAttendance(attendance);
        return Result.success("考勤补录成功");
    }

    @RequestMapping("/empadd")
    @ResponseBody
    public Result<Object> EmpAddaAttendance(HttpSession session) throws ParseException {
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Employee employee = (Employee) session.getAttribute("loginUser");
        boolean flag = attendanceService.queryByEmpAndDate(employee.getName(), new java.sql.Date(new Date().getTime())) == null;
        if (!flag) {
            return Result.fail("你今日已打过卡了");
        } else {
            Attendance attendance = new Attendance();
            attendance.setStatus(2);
            attendance.setEmployee_name(employee.getName());
            attendance.setStartDate(new java.sql.Date(new Date().getTime()));
            attendance.setStarttime(time.parse(time.format(new Date())));
            attendanceService.addAttendance(attendance);
            return Result.success(employee.getName() + "打卡成功");
        }
    }


    @GetMapping("/{id}")
    public String queryAttendanceById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("empList", employeeService.queryAll());
        model.addAttribute("attendance", attendanceService.queryById(id));
        return "attendance/attendanceedit";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result<Object> updateAttendance(String id, String startDate, String starttime, String endtime, String employee_name, String status) throws ParseException {
        Attendance attendance = attendanceService.queryById(Integer.valueOf(id));
        Date startDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date starttime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(starttime);
        Date endtime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endtime);
        Long time = endtime1.getTime() - starttime1.getTime();
        Double worktime = time / 1000.0 / 60.0 / 60.0;
        if (worktime <= 0) {
            return Result.fail("工作时长不能为0或小于0");
        } else {
            attendance.setStarttime(startDate1);
            attendance.setEmployee_name(employee_name);
            attendance.setWorktime(DoubleFX.getDoubleToString(worktime, 2));
            attendance.setStarttime(starttime1);
            attendance.setEndtime(endtime1);
            attendance.setStatus(Integer.parseInt(status));
            attendanceService.updateAttendance(attendance);
            return Result.success("修改成功");
        }
    }


    @RequestMapping("/empupdate")
    @ResponseBody
    public Result<Object> EmpupdateAttendance(HttpSession session) throws ParseException {
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Employee employee = (Employee) session.getAttribute("loginUser");
        Attendance attendance = attendanceService.queryByEmpAndDate(employee.getName(), new java.sql.Date(new Date().getTime()));
        Date date = time.parse(time.format(new Date()));
        if (attendance == null) {
            return Result.fail("你今日还未打卡");
        } else {
            Long time1 = date.getTime() - attendance.getStarttime().getTime();
            Double worktime = time1 / 1000.0 / 60.0 / 60.0;
            if (worktime <= 0) {
                return Result.fail("工作时长不能为0或小于0");
            } else {
                if (attendance.getStatus() == 2) {
                    attendance.setStatus(1);
                    attendance.setWorktime(DoubleFX.getDoubleToString(worktime, 2));
                    attendance.setEndtime(date);
                    attendanceService.updateAttendance(attendance);
                    return Result.success("下班成功");
                } else {
                    return Result.fail("您今日已打卡下班，如打卡有误，请联系管理员修改");
                }
            }
        }
    }

    @PostMapping("/delete/{ids}")
    @ResponseBody
    public Result<Object> deleteAttendance(@PathVariable("ids") String ids) {
        attendanceService.deleteAttendanceById(ids);
        return Result.success("删除考勤成功");
    }

}
