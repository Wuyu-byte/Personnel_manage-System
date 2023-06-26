package com.xlk.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zhaochangxin
 * @Title: Health
 * @Package com.xlk.pojo
 * @Description: Health
 * @date 2022/4/12 14:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Health {
    private int id;
    private String employee_name;
    private Double temperature;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createdate;
    private String image;
    private String image2;

}
