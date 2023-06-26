package com.xlk.controller;

import com.xlk.common.util.DoubleFX;
import com.xlk.common.vo.AttendanceQuery;
import com.xlk.common.vo.NoticeQuery;
import com.xlk.common.vo.Result;
import com.xlk.pojo.Attendance;
import com.xlk.pojo.Notice;
import com.xlk.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zhaochangxin
 * @Title: NoticeController
 * @Package com.xlk.controller
 * @Description: NoticeController
 * @date 2022/4/6 15:38
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    NoticeService noticeService;
    @GetMapping("")
    public String toNoticeListUI() {
        return "notice/noticelist";
    }

    @GetMapping("/list")
    @ResponseBody//返回Json
    public Result<Object> getNoticeList(NoticeQuery param) {
        List<Notice> list = noticeService.getNoticeList(param);
        Long count = noticeService.countNoticeList(param);
        return Result.success("success", list, count);
    }

    @RequestMapping("/NoticeAdd")
    public String toNoticeAdd() {
        return "notice/noticeadd";
    }

    @PostMapping("/add")
    @ResponseBody
    public Result<Object> addNotice(String message){
        Notice notice = new Notice();
        notice.setCreate_date(new Date());
        notice.setStart_date(new Date());
        notice.setMessage(message);
        notice.setUser_name("admin");
        noticeService.addNotice(notice);
        return Result.success("公告发布成功");
    }

    @PostMapping("/delete/{ids}")
    @ResponseBody
    public Result<Object> deleteNotice(@PathVariable("ids") String ids) {
        noticeService.deleteNoticeById(ids);
        return Result.success("删除公告成功");
    }



}
