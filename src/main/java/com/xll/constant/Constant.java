package com.xll.constant;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author : XuLeLe
 * @Date : 2021/01/27/12:05
 * @Description: 配置常用的常量
 */
public class Constant {

    public interface RESPCODE {
        String SUCCESS = "200";
        String FAIL = "400";
        String FALSE = "404";
        String ERROR = "-1";
    }

    public interface RESPMSG {
        String SUCCESS = "请求成功";
        String ERROR = "请求失败";
    }
}
