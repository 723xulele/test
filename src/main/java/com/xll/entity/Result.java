package com.xll.entity;

import com.xll.constant.Constant;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author : XuLeLe
 * @Date : 2021/01/27/18:02
 * @Description: 返回结果封装
 */
@Data
public class Result<T> implements Serializable {

    //返回数据
    private T data;

    //返回状态码
    private String code;

    //返回描述
    private String msg;

    //数量统计
    private Integer total;

    public Result() {
        this.code = Constant.RESPCODE.SUCCESS;
        this.msg = "请求成功";
    }

    public Result(String code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(String code,String msg, T data){
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Result(String code,String msg,T data, Integer total) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = total;
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(String code,T data) {
        this.data = data;
        this.code = code;
    }
}
