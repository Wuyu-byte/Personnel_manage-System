package com.xlk.mapper;

import com.xlk.common.vo.LeaveQuery;
import com.xlk.pojo.Attendance;
import com.xlk.pojo.Leave;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LeaveMapper {

    List<Attendance> getLeaveList(LeaveQuery param);

    Long countLeaveList(LeaveQuery param);


    Leave queryLeaveById(Integer id);


    void updateLeave(Leave leave);

    void addLeave(Leave leave);

}
