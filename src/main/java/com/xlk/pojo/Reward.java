package com.xlk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reward {
    private Integer id;
    private String department_name;
    private String employee_name;
    private String theme;
    private String status;
    private String price;
    private String message;

}
