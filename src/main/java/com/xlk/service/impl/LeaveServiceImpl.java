package com.xlk.service.impl;

import com.xlk.common.vo.LeaveQuery;
import com.xlk.mapper.LeaveMapper;
import com.xlk.pojo.Attendance;
import com.xlk.pojo.Leave;
import com.xlk.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    LeaveMapper leaveMapper;
    @Override
    public List<Attendance> getLeaveList(LeaveQuery param) {
        return leaveMapper.getLeaveList(param);
    }

    @Override
    public Long countLeaveList(LeaveQuery param) {
        return leaveMapper.countLeaveList(param);
    }

    @Override
    public Leave queryLeaveById(Integer id) {
        return leaveMapper.queryLeaveById(id);
    }

    @Override
    public void updateLeave(Leave leave) {
        leaveMapper.updateLeave(leave);
    }

    @Override
    public void addLeave(Leave leave) {
        leaveMapper.addLeave(leave);
    }
}
