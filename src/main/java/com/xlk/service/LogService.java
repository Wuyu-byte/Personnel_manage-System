package com.xlk.service;


import com.xlk.pojo.Log;
import com.xlk.pojo.LogExample;

import java.util.List;

/**
 * @author zhaochangxin
 * @date 2022/3/8 13:35
 * 日志接口
 */
public interface LogService {
    // 查询所有日志信息
    List<Log> queryLogList(LogExample logExample);
    // 插入日志
    void insertLog(Log log);

    void deleteLogById(String ids);
}
