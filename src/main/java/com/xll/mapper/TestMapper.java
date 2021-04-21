package com.xll.mapper;

import com.xll.entity.po.UsersPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author : XuLeLe
 * @Date : 2021/01/28/10:43
 * @Description:
 */
@Mapper
public interface TestMapper {

    List<UsersPo> testGetAllUsers();
}
