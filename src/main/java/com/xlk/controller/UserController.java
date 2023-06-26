package com.xlk.controller;

import com.wf.captcha.utils.CaptchaUtil;
import com.xlk.common.vo.Result;
import com.xlk.pojo.User;
import com.xlk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public Object Login(User param, HttpSession session, @RequestParam("captcha") String captcha, HttpServletRequest request){
        if(!CaptchaUtil.ver(captcha,request))
        {
            return Result.fail("验证码错误");
        }
        User user= userService.login(param);//通过用户名查询用户
        if(user!=null)
        {
            BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();//新建springSecurity验证
            boolean matches = passwordEncoder.matches(param.getPassword(), user.getPassword());//验证密码
            if (matches) {
                if(user.getStatus()==1)
                {
                    session.setAttribute("loginUser",user);
                    return Result.success();
                }
                else
                {
                    return Result.fail("用户已被禁止登陆");
                }

            }
        }
        return Result.fail("用户名或密码错误");
    }

    @RequestMapping("/loginout")
    @ResponseBody
    public Result<Object> loginout(HttpSession session){
        session.removeAttribute("loginUser");
        return Result.success("退出成功");
    }
    @RequestMapping("/updatePassword")
    public Result<Object> updatePassword(HttpSession session,String old_password,String new_password,String again_password){
        User loginUser = (User) session.getAttribute("loginUser");
        //验证密码
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();//新建springSecurity验证
        boolean matches = passwordEncoder.matches(old_password, loginUser.getPassword());//验证密码
        System.out.println(matches);
        if(matches)
        {
            if(new_password.equals(again_password))
            {
                loginUser.setPassword(passwordEncoder.encode(new_password));
                userService.updatePassword(loginUser);
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
