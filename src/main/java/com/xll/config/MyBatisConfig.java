package com.xll.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author : XuLeLe
 * @Date : 2021/01/27/15:18
 * @Description:
 */
@MapperScan("com.xll.mapper")
@Configuration
public class MyBatisConfig {

//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        //设置请求的界面大于最后页面进行操作,true调回到首页,false 继续请求, 默认为false
//        //paginationInterceptor().setOverflow(false);
//        //设置最大单页限制数量,默认500条,-1不受限制
//        //paginationInterceptor().setLimit(5);
//        //开启count的join优化,只针对部分 left join
//        //paginationInterceptor().setCountSqlParser(new JsqlParserCountOptimize(true));
//        return paginationInterceptor();
//    }
}
