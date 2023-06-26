package com.xlk.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhaochangxin
 * @Title: HealthQuery
 * @Package com.xlk.common.vo
 * @Description: HealthQuery
 * @date 2022/4/12 14:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthQuery extends Page {
    private String employee_name;
    private String createdate;
}
