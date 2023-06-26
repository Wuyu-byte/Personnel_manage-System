package com.xlk.controller;

import com.xlk.common.util.FileUtil;
import com.xlk.common.vo.FileQuery;
import com.xlk.common.vo.Result;
import com.xlk.pojo.xlkFile;
import com.xlk.service.xlkFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/filedDownload")
public class FileDownloadController {
    @Autowired
    xlkFileService xlkFileService;

    //跳转下载路径
    @RequestMapping("")
    public String toFileDownloadUi()
    {
        return "file/fileList";
    }

    //遍历返回File
    @GetMapping("/list")
    @ResponseBody
    public Result<Object> getDeptList(FileQuery param){
        List<xlkFile> list=xlkFileService.getFileList(param);
        Long count=xlkFileService.countFileList(param);
        return Result.success("success",list,count);
    }

    //删除文件
    @PostMapping("/delete/{ids}")
    @ResponseBody
    public Result<Object> deleteFileById(@PathVariable("ids") String ids)
    {
        List<xlkFile> files=xlkFileService.queryFileByIds(ids);
        if(files!=null)
        {
            for (xlkFile file : files) {
                File filedelete=new File(file.getFilesrc());
                if(filedelete.exists()&&filedelete.isFile())
                {
                    filedelete.delete();
                    xlkFileService.deleteFileById(ids);
                }
            }
            return Result.success("删除文件成功");
        }
        else
        {
            return Result.fail("未查询到文件数据,请刷新重试");
        }
    }


    @RequestMapping(value="/down", produces = {"application/text;charset=UTF-8"})
    @ResponseBody
    public Result<Object> down(HttpServletResponse response, String id){
        try {
            System.out.println(id);
            //根据文件id查询文件路径
            String filePath = xlkFileService.queryFileById(id).getFilesrc();
            //根据文件路径下载文件信息
            FileUtil.down(response, filePath);
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            return Result.success("下载成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.fail("下载失败");
    }

}
