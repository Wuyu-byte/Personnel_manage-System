package com.xlk.emp.controller;

import com.xlk.common.util.DoubleFX;
import com.xlk.common.vo.HealthQuery;
import com.xlk.common.vo.Result;
import com.xlk.pojo.Attendance;
import com.xlk.pojo.Employee;
import com.xlk.pojo.Health;
import com.xlk.service.EmployeeService;
import com.xlk.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zhaochangxin
 * @Title: HealthController
 * @Package com.xlk.controller
 * @Description: HealthController
 * @date 2022/4/12 14:19
 */
@Controller
@RequestMapping("/health2")
public class HealthController2 {
    @Autowired
    HealthService healthService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public String toHealthListUI() {
        return "health/healthList2";
    }

    @GetMapping("/list")
    @ResponseBody
    public Result<Object> getHealthList(HealthQuery param,HttpSession session) {
        Employee loginUser = (Employee) session.getAttribute("loginUser");
        param.setEmployee_name(loginUser.getName());
        List<Health> list = healthService.getHealthList(param);
        Long count = healthService.countHealthList(param);
        return Result.success("success", list, count);
    }

    @GetMapping("/get/{id}")
    public String queryHealthById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("empList", employeeService.queryAll());
        model.addAttribute("health", healthService.queryById(id));
        return "health/healthedit";
    }

    @ResponseBody
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public Map<String, Object> uploadFile(HttpServletRequest servletRequest, @RequestParam("file") MultipartFile file, HttpSession session, String emp, String date)
            throws IOException {
        // 如果文件内容不为空，则写入上传路径
        if (!file.isEmpty()) {
            // 上传文件路径
            String UploadPath = "D:\\文档\\Ideaworkpasce\\springbootdemo01\\src\\main\\resources\\static\\health";
            //取得原文件名字
            String fileName = file.getOriginalFilename();
            //取得文件扩展名
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            //提取系统时间作为新文件名
            String prefix = date.replaceAll("-", "");
            System.out.println(prefix);
            //保存路径
            // 上传文件名
            String filename = emp + prefix + "jk" + UUID.randomUUID() + suffix;
            File filepath = new File(UploadPath, filename);
            // 判断路径是否存在,没有创建
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            // 将上传文件保存到一个目标文档中
            File file1 = new File(UploadPath + File.separator + filename);
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file1));
            out.write(file.getBytes());
            out.flush();
            out.close();

//            file.transferTo(file1);
            Map<String, Object> res = new HashMap<>();
            // 返回的是一个url对象,图片名称
            res.put("url", filename);
            return res;
        } else {
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/uploadFile2", method = RequestMethod.POST)
    public Map<String, Object> uploadFile2(HttpServletRequest servletRequest, @RequestParam("file") MultipartFile file, HttpSession session, String emp, String date)
            throws IOException {
        // 如果文件内容不为空，则写入上传路径
        if (!file.isEmpty()) {
            // 上传文件路径
            String UploadPath = "D:\\文档\\Ideaworkpasce\\springbootdemo01\\src\\main\\resources\\static\\health";
            //取得原文件名字
            String fileName = file.getOriginalFilename();
            //取得文件扩展名
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            //提取系统时间作为新文件名
            String prefix = date.replaceAll("-", "");
            System.out.println(prefix);
            //保存路径
            // 上传文件名
            String filename = emp + prefix + "xc" + UUID.randomUUID() + suffix;
            File filepath = new File(UploadPath, filename);
            // 判断路径是否存在,没有创建
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            // 将上传文件保存到一个目标文档中
            File file1 = new File(UploadPath + File.separator + filename);
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file1));
            out.write(file.getBytes());
            out.flush();
            out.close();

//            file.transferTo(file1);
            Map<String, Object> res = new HashMap<>();
            // 返回的是一个url对象,图片名称
            res.put("url", filename);
            return res;
        } else {
            return null;
        }
    }



    @RequestMapping("/update")
    @ResponseBody
    public Result<Object> updateHealth(String id, String employee_name, String temperature, String pic,String pic2) throws ParseException {
        Health health = healthService.queryById(Integer.valueOf(id));
        if (health.getEmployee_name().equals(employee_name)) {
            health.setTemperature(Double.valueOf(temperature));
            health.setImage("image\\" + pic);
            health.setImage2("image\\" + pic2);
            healthService.updateHealth(health);
            return Result.success("修改成功");
        } else {
            return Result.fail("修改失败");
        }
    }

    @PostMapping("/add")
    @ResponseBody
    public Result<Object> addaHealth(String temperature, String pic,String pic2,HttpSession session) throws ParseException {
        Employee loginUser = (Employee) session.getAttribute("loginUser");
        Health health=new Health();
        health.setEmployee_name(loginUser.getName());
        health.setCreatedate(new Date());
        health.setTemperature(Double.valueOf(temperature));
        health.setImage("image\\" + pic);
        health.setImage2("image\\" + pic2);
        healthService.addHealth(health);
        return Result.success("日报上传成功");
    }

    //添加部门页面跳转
    @RequestMapping("/HealthAdd")
    public String toAttendanceAdd(Model model,HttpSession session) {
        Employee loginUser = (Employee) session.getAttribute("loginUser");
        model.addAttribute("user",loginUser);
        String startDate1 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        model.addAttribute("date",startDate1);

        return "health/healthadd";
    }



}
