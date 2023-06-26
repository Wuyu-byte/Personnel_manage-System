package com.xlk.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class AttendanceQuery extends Page {
    private String employee_name;
    private String startDate;
}