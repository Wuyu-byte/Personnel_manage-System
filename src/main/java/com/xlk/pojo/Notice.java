package com.xlk.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zhaochangxin
 * @Title: Notice
 * @Package com.zcx.pojo
 * @Description: Notice
 * @date 2022/4/6 15:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    private int id;
    private String user_name;
    private String message;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date create_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date start_date;
}
