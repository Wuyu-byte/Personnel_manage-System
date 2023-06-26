package com.xlk.service.impl;

import com.xlk.common.vo.AttendanceQuery;
import com.xlk.mapper.AttendanceMapper;
import com.xlk.pojo.Attendance;
import com.xlk.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceMapper attendanceMapper;
    @Override
    public List<Attendance> getAttendanceList(AttendanceQuery param) {
        return attendanceMapper.getAttendanceList(param);
    }

    @Override
    public Long countAttendanceList(AttendanceQuery param) {
        return attendanceMapper.countAttendanceList(param);
    }

    @Override
    public void addAttendance(Attendance attendance) {
        attendanceMapper.addAttendance(attendance);
    }

    @Override
    public Attendance queryById(Integer id) {
        return attendanceMapper.queryById(id);
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        attendanceMapper.updateAttendance(attendance);
    }

    @Override
    public void deleteAttendanceById(String ids) {
        attendanceMapper.deleteAttendanceById(ids);
    }

    @Override
    public Attendance queryByEmpAndDate(String name, Date date) {
        return attendanceMapper.queryByEmpAndDate(name,date);
    }
}
