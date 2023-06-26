package com.xlk.service;

import com.xlk.common.vo.AttendanceQuery;
import com.xlk.pojo.Attendance;

import java.sql.Date;
import java.util.List;

public interface AttendanceService {

    List<Attendance> getAttendanceList(AttendanceQuery param);

    Long countAttendanceList(AttendanceQuery param);

    void addAttendance(Attendance attendance);

    Attendance queryById(Integer id);

    void updateAttendance(Attendance attendance);

    void deleteAttendanceById(String ids);

    Attendance queryByEmpAndDate(String name, Date date);

}
