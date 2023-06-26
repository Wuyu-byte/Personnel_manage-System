package com.xlk.common.vo;

import lombok.Data;

@Data
public class LeaveQuery extends Page {
    private String employee_name;
    private String leave_message;

}
