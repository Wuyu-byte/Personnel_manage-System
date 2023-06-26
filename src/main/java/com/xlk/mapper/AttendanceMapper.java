package com.xlk.mapper;

import com.xlk.common.vo.AttendanceQuery;
import com.xlk.pojo.Attendance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Mapper
@Repository
public interface AttendanceMapper {
    List<Attendance> getAttendanceList(AttendanceQuery param);

    Long countAttendanceList(AttendanceQuery param);

    void addAttendance(Attendance attendance);

    Attendance queryById(Integer id);

    void updateAttendance(Attendance attendance);

    void deleteAttendanceById(String ids);

    Attendance queryByEmpAndDate(@Param("name")String name, @Param("date")Date date);

}
