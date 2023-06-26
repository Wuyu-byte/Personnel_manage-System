package com.xlk.emp.controller;

import com.xlk.common.vo.Result;
import com.xlk.common.vo.RewardQuery;
import com.xlk.pojo.Employee;
import com.xlk.pojo.Reward;
import com.xlk.service.DepartmentService;
import com.xlk.service.EmployeeService;
import com.xlk.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/empreward")
@Controller
public class RewardController2 {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    RewardService rewardService;
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("")
    public String toRewardUi(Model model){
        model.addAttribute("deptList",departmentService.queryAll());
        return "reward/rewardList2";
    }


    @GetMapping("/list")
    @ResponseBody
    public Result<Object> getRewardList(RewardQuery param, HttpSession session) {
        Employee loginUser = (Employee) session.getAttribute("loginUser");
        param.setEmployee_name(loginUser.getName());
        List<Reward> list = rewardService.getRewardList(param);
        Long count = rewardService.countRewardList(param);
        return Result.success("success", list, count);
    }

    @RequestMapping("/rewardAdd")
    public String toRewardAdd(Model model){
        model.addAttribute("deptList",departmentService.queryAll());
        return "reward/rewardadd";
    }

    @PostMapping("/add")
    @ResponseBody
    public Result<Object> addReward(Reward reward)
    {
        reward.setDepartment_name(departmentService.queryById(reward.getDepartment_name()).getName());
        reward.setEmployee_name(employeeService.queryEmpById(Integer.valueOf(reward.getEmployee_name())).getName());
        rewardService.addReward(reward);
        return Result.success("添加奖惩成功");
    }

    //获取单个员工信息
    @GetMapping("/{id}")
    public String queryRewardById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("reward",rewardService.queryById(id));
        return "reward/rewardedit";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result<Object> updateReward(Reward reward)
    {
        Reward rewardold=rewardService.queryById(reward.getId());
        rewardold.setMessage(reward.getMessage());
        rewardold.setPrice(reward.getPrice());
        rewardold.setStatus(reward.getStatus());
        rewardold.setTheme(reward.getTheme());
        rewardService.updateReward(reward);
        return Result.success("修改成功");
    }


    @PostMapping("/delete/{ids}")
    @ResponseBody
    public Result<Object> deleteRewardById(@PathVariable("ids") String ids)
    {
        rewardService.deleteRewardById(ids);
        return Result.success("删除成功");
    }

}
