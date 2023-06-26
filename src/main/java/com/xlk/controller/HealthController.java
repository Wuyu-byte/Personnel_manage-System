package com.xlk.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.xlk.common.vo.HealthQuery;
import com.xlk.common.vo.Result;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author zhaochangxin
 * @Title: HealthController
 * @Package com.xlk.controller
 * @Description: HealthController
 * @date 2022/4/12 14:19
 */
@Controller
@RequestMapping("/health")
public class HealthController {
    @Autowired
    HealthService healthService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public String toHealthListUI() {
        return "health/healthList";
    }

    @GetMapping("/list")
    @ResponseBody
    public Result<Object> getHealthList(HealthQuery param) {
        List<Health> list = healthService.getHealthList(param);
        Long count = healthService.countHealthList(param);
        return Result.success("success", list, count);
    }


    @PostMapping("/delete/{ids}")
    @ResponseBody
    public Result<Object> deleteHealth(@PathVariable("ids") String ids) {
        healthService.deleteHealthById(ids);
        return Result.success("删除日报成功");
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
        System.out.println(pic2);
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
}
