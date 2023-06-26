package com.xlk.service;

import com.xlk.common.vo.LeaveQuery;
import com.xlk.pojo.Attendance;
import com.xlk.pojo.Leave;

import java.util.List;

public interface LeaveService {
    List<Attendance> getLeaveList(LeaveQuery param);

    Long countLeaveList(LeaveQuery param);

    Leave queryLeaveById(Integer id);

    void updateLeave(Leave leave);

    void addLeave(Leave leave);

}
