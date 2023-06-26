package com.xlk.controller;

import com.xlk.common.vo.DeptQuery;
import com.xlk.common.vo.FileQuery;
import com.xlk.common.vo.Result;
import com.xlk.pojo.Employee;
import com.xlk.pojo.xlkFile;
import com.xlk.service.xlkFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mysql.cj.CharsetMapping.MAP_SIZE;

@Controller
@RequestMapping("/fileUpLoad")
public class FileUpLoadController {
    @Autowired
    xlkFileService xlkFileService;
    //上传路径
    @RequestMapping("")
    public String toFileUpLoadUi()
    {
        return "file/fileupload";
    }

    public final static String UPLOAD_FILE_PATH = "D:\\文档\\Ideaworkpasce\\springbootdemo01\\src\\main\\resources\\static\\FileUpLoad";
    //上传文件方法与插入数据库
    @RequestMapping(value = "uploadFile")
    @ResponseBody
    public Result<Object> uploadImage(@RequestParam("file") MultipartFile file) {

        xlkFile sqlfile=new xlkFile();
        String filename = file.getOriginalFilename().substring(0,file.getOriginalFilename().lastIndexOf("."));
        String[] fileTyle = file.getOriginalFilename().split("\\.");
        int suffixIndex = fileTyle.length -1;
        sqlfile.setFilename(filename);
        sqlfile.setFilesize(file.getSize());
        sqlfile.setFilesrc(UPLOAD_FILE_PATH+"\\"+file.getOriginalFilename());
        sqlfile.setFiletype(fileTyle[suffixIndex]);
        System.out.println(sqlfile);
        xlkFileService.addXlkFile(sqlfile);
        if (!file.isEmpty()) {
            Map<String, String> resObj = new HashMap<>(MAP_SIZE);
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(UPLOAD_FILE_PATH, file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                return Result.fail("上传失败");
            }
            return Result.success("上传成功");
        } else {
            return null;
        }
    }
}
