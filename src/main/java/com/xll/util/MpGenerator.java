package com.xll.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author : XuLeLe
 * @Date : 2021/01/27/11:11
 * @Description: mp代码生成器
 */
public class MpGenerator {
    public static void main(String[] args) {
    //数据源地址
    String dataUrl ="jdbc:mysql://localhost:3306/java03?useUnicode=true&characterEncoding=utf8";
    //数据源账户
    String username ="root";
    //数据源密码
    String password = "123456";
    //待生成表名
    String tableName = "animal";
    //待生成文件名
    String fileName = "Animal";

    //System.getProperty("user.dir")  拿到项目名 往后面拼接文件夹名称
    String path = System.getProperty("user.dir") + "\\src\\main\\java\\";

    // AutoGenerator 是 MyBatis-Plus 的代码生成器，通过 AutoGenerator 可以快速生成 Entity、Mapper、Mapper XML、Service、Controller 等各个模块的代码，极大的提升了开发效率。可以通过模版等一系列的方式来生成代码
    AutoGenerator mpg = new AutoGenerator();

    //全局配置
    GlobalConfig gc =new GlobalConfig();
    //输出文件路径
    gc.setOutputDir(path);
    gc.setFileOverride(true);
    //不需要ActiveRecord改为false
    gc.setActiveRecord(false);
    //XML 二级缓存
    gc.setEnableCache(false);
    //XML ResultMap
    gc.setBaseResultMap(true);
    //XML columnList
    gc.setBaseColumnList(false);
    // 作者
    gc.setAuthor("XuLeLe");


    String name = fileName;
    // 自定义文件名 注意%s 会自动填充表实体属性
    gc.setEntityName(name+"Po");
    gc.setDateType(DateType.ONLY_DATE);
    gc.setControllerName("%sController");
    gc.setServiceName("%sService");
    gc.setServiceImplName("%sServiceImpl");
    gc.setMapperName("%sMapper");
    gc.setXmlName("%sMapper");
    mpg.setGlobalConfig(gc);

    //数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setDbType(DbType.MYSQL);
    dsc.setDriverName("com.mysql.jdbc.Driver");
    dsc.setPassword(password);
    dsc.setUsername(username);
    dsc.setUrl(dataUrl);
    mpg.setDataSource(dsc);

    //策略配置
    StrategyConfig strategy = new StrategyConfig();
    //此处可用来修改表的前缀
//    strategy.setTablePrefix(new String[] { "tlog_"});
    //表名生成策略
    strategy.setNaming(NamingStrategy.underline_to_camel);
    //是否启动Lombok 可增加实体类中的set get方法 可选择false或者true
    strategy.setEntityLombokModel(true);
    //需要生成的表
    strategy.setInclude(new String[] { tableName });
    strategy.setSuperServiceClass(null);
    strategy.setSuperServiceImplClass(null);
    strategy.setSuperMapperClass(null);
    mpg.setStrategy(strategy);

    //包配置
    PackageConfig pc = new PackageConfig();
    pc.setParent("com.xll");
    /*pc.setController("controller");
    pc.setService("service");
    pc.getServiceImpl("service.Impl");
    pc.setMapper("mapper");*/
    pc.setEntity("entity.po");
    Map<String,String> packgeInfo = new HashMap<>();
    packgeInfo.put(ConstVal.ENTITY,"com.xll.entity.po");
    packgeInfo.put(ConstVal.SERVICE,"com.xll.services");
    packgeInfo.put(ConstVal.SERVICE_IMPL,"com.xll.services.impl");
    packgeInfo.put(ConstVal.MAPPER,"com.xll.mapper");
    Map pathInfo = new HashMap();
    pathInfo.put(ConstVal.ENTITY_PATH,path+packgeInfo.get(ConstVal.ENTITY).replaceAll("\\.", StringPool.BACK_SLASH+ File.separator));
    pathInfo.put(ConstVal.SERVICE_PATH,path+packgeInfo.get(ConstVal.SERVICE).replaceAll("\\.", StringPool.BACK_SLASH+ File.separator));
    pathInfo.put(ConstVal.SERVICE_IMPL_PATH,path+packgeInfo.get(ConstVal.SERVICE_IMPL).replaceAll("\\.", StringPool.BACK_SLASH+ File.separator));
    pathInfo.put(ConstVal.MAPPER_PATH,path+packgeInfo.get(ConstVal.MAPPER).replaceAll("\\.", StringPool.BACK_SLASH+ File.separator));
    pathInfo.put(ConstVal.XML_PATH,System.getProperty("user.dir")+"\\src\\main\\resources\\mapper\\");
    pc.setPathInfo(pathInfo);
    mpg.setPackageInfo(pc);

    //执行生成
    mpg.execute();
    }
}
