package com.xlk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee implements Serializable {
    private Integer id;
    private String employee_id;
    private String name;
    private String phone;
    private String email;
    private Department department;
    private Level level;
    private String username;
    private String password;
    private Integer age;
    private Integer sex;
    private Integer status;
}
