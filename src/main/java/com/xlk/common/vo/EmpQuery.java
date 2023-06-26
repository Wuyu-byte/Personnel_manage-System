package com.xlk.common.vo;

import com.xlk.pojo.Department;
import lombok.Data;
import org.springframework.web.servlet.tags.Param;

@Data
public class EmpQuery extends Page {
    private String name;
    private String age;
    private Integer department_id;
}
