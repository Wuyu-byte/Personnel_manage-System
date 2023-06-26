package com.xlk.service.impl;

import com.xlk.mapper.LogMapper;
import com.xlk.pojo.Log;
import com.xlk.pojo.LogExample;
import com.xlk.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaochangxin
 * @date 2022/3/8 13:41
 * Log Service层
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;
    @Override
    public List<Log> queryLogList(LogExample logExample) {
        return logMapper.selectByExample(logExample);
    }

    @Override
    public void insertLog(Log log) {
        logMapper.insert(log);
    }

    @Override
    public void deleteLogById(String ids) {
        logMapper.deleteByPrimaryKey(Long.valueOf(ids));
    }
}
