package com.xlk.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"/","/login"})
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }
    @RequestMapping("/welcome")
    public String toWelcome(){
        return "welcome";
    }
    @RequestMapping("/empwelcome")
    public String toEmpWelcome(){
        return "empwelcome";
    }

    @RequestMapping("/updatePassword")
    public String toUpdatePassword(){
        return "password";
    }
    @RequestMapping("/updateEmpPassword")
    public String toEmpUpdatePassword(){
        return "emppassword";
    }

    @RequestMapping("/emplogin")
    public String toEmpLogin(){
        return "emplogin";
    }
    @RequestMapping("/empindex")
    public String toEmpIndex(){
        return "empindex";
    }
}
