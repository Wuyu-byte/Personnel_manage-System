package com.xlk.controller;

import com.wf.captcha.utils.CaptchaUtil;
import com.xlk.common.vo.Result;
import com.xlk.pojo.Employee;
import com.xlk.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.UnknownHostException;

@Controller
@RequestMapping("/emplogin")
public class EmpLoginController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    LogController logController;

    @RequestMapping("/login")
    @ResponseBody
    public Result<Object> Login(Employee param, HttpSession session, @RequestParam("captcha") String captcha, HttpServletRequest request) throws UnknownHostException {
        if(!CaptchaUtil.ver(captcha,request))
        {
            logController.insertLog(param,"验证码错误");
            return Result.fail("验证码错误");
        }
        Employee employee= employeeService.login(param);//通过用户名查询用户
        System.out.println(employee);
        if(employee!=null)
        {
            boolean matches=employee.getPassword().equals(param.getPassword());
//            BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();//新建springSecurity验证
//            boolean matches = passwordEncoder.matches(param.getPassword(), employee.getPassword());//验证密码
            if (matches) {
                if(employee.getStatus()==1)
                {
                    session.setAttribute("loginUser",employee);
                    logController.insertLog(employee,"登陆成功");
                    return Result.success();
                }
                else
                {
                    logController.insertLog(employee,"用户已被禁止登陆");
                    return Result.fail("用户已被禁止登陆");
                }

            }
        }
        logController.insertLog(employee,"用户名或密码错误");
        return Result.fail("用户名或密码错误");
    }
}
