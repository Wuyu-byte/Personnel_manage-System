package com.xlk.common.vo;

import com.alibaba.druid.filter.AutoLoad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//结果集类
public class Result<T> {
    private Integer code;   //返回码
    private String message; //返回信息
    private Long count;     //分页查询
    private T data;         //返回数据

    public static Result<Object> success()
    {
        return new Result(0,"success",null,null);
    }
    public static Result<Object> success(String message)
    {
        return new Result(0,message,null,null);
    }
    public static Result<Object> success(String message,Object data)
    {
        return new Result(0,message,null,data);
    }
    public static Result<Object> success(String message,Object data,long limit) {
        return new Result(0,message,limit,data);
    }
    public static Result<Object> fail()
    {
        return new Result(-1,"fail",null,null);
    }
    public static Result<Object> fail(String message)
    {
        return new Result(-1,message,null,null);
    }
}
