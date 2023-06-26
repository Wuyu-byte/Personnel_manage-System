package com.xlk.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page implements Serializable {
    private Integer page;
    private Integer limit;
    public Long getStart(){
        return (this.page-1L)*limit;
    }
}
