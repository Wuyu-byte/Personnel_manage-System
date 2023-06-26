package com.xlk.controller;

import com.xlk.common.vo.Result;
import com.xlk.pojo.Employee;
import com.xlk.pojo.Log;
import com.xlk.pojo.LogExample;
import com.xlk.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @author zhaochangxin
 * @date 2022/3/8 13:47
 * 日志控制层
 */
@Controller
@RequestMapping("/log")
public class LogController {
    //常量定义
    private static final String LOG_QUERY_SUCCESS = "查询完毕";
    private static final String LOG_INSERT_SUCCESS = "插入成功";
    private static final String LOG_DELETE_SUCCESS = "删除成功";

    @Autowired
    LogService logService;
    @RequestMapping("")
    public String toLogUi(){
        return "log/loglist";
    }
    /**
     * queryLogList 查询所有日志信息
     * @param logExample
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Result queryLogList(LogExample logExample) {
        LogExample.Criteria criteria = logExample.createCriteria();
        criteria.andCreatedByIsNotNull();
        List<Log> logsList = logService.queryLogList(logExample);
        return Result.success(LOG_QUERY_SUCCESS, logsList);
    }

    /**
     * @param msg
     * @return ApiResult
     * @throws UnknownHostException 插入日志 insertLog
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result insertLog(Employee employee, String msg) throws UnknownHostException {
        Log log = new Log();
        InetAddress addr = InetAddress.getLocalHost();
        log.setLoginIp(addr.getHostAddress());
        log.setLoginName(employee.getUsername());
        log.setLoginMsg(msg);
        log.setCreatedBy(Long.valueOf(1));
        log.setCreatedDate(new java.sql.Date(new java.util.Date().getTime()));
        log.setOwner("zcx");
        logService.insertLog(log);
        return Result.success(LOG_INSERT_SUCCESS);
    }

    /**
     * 删除日志 deleteLogById
     * @param ids
     * @return ApiResult
     */
    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public Result deleteLogById(@PathVariable("ids") String ids) {
        logService.deleteLogById(ids);
        return Result.success(LOG_DELETE_SUCCESS);
    }
}
