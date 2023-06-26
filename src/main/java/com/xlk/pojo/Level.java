package com.xlk.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Level implements Serializable {
    private String id;
    private String name;
    private String des;
    private String department_name;
}
