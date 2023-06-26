package com.xlk.emp.controller;

import com.xlk.common.vo.NoticeQuery;
import com.xlk.common.vo.Result;
import com.xlk.pojo.Notice;
import com.xlk.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/notice2")
public class NoticeController2 {
    @Autowired
    NoticeService noticeService;
    @GetMapping("")
    public String toNoticeListUI() {
        return "notice/noticelist2";
    }

    @GetMapping("/list")
    @ResponseBody//返回Json
    public Result<Object> getNoticeList(NoticeQuery param) {
        List<Notice> list = noticeService.getNoticeList(param);
        Long count = noticeService.countNoticeList(param);
        return Result.success("success", list, count);
    }
}
