package com.xll;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author : XuLeLe
 * @Date : 2021/01/27/9:58
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.xll.mapper")
public class testApplication {
    public static void main(String[] args) {
        SpringApplication.run(testApplication.class,args);
    }
}
