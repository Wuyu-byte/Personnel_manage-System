package com.xlk.controller;

import com.xlk.common.vo.LeaveQuery;
import com.xlk.common.vo.Result;
import com.xlk.pojo.Attendance;
import com.xlk.pojo.Leave;
import com.xlk.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    LeaveService leaveService;
    @GetMapping("")
    public String toLeaveListUI() {
        return "leave/leaveList";
    }

    @GetMapping("/list")
    @ResponseBody//返回Json
    public Result<Object> getLeaveList(LeaveQuery param) {
        System.out.println(param);
        List<Attendance> list = leaveService.getLeaveList(param);
        System.out.println(list);
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
}
