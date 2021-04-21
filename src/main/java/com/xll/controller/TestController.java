package com.xll.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xll.entity.po.UsersPo;
import com.xll.mapper.UsersMapper;
import com.xll.service.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author : XuLeLe
 * @Date : 2021/01/28/16:10
 * @Description:
 */
@RestController
@RequestMapping(value = "test")
public class TestController {
    @Resource
    private UsersService usersService;
    @Resource
    private UsersMapper usersMapper;

    @GetMapping(value = "/addUser")
    public String addUser () {
       UsersPo usersPo = new UsersPo();
       usersPo.setAddr("xian");
       usersPo.setPassword("xian");
       usersPo.setTel("test");
       usersPo.setUsername("bbb");
//       usersPo.setUid(325);
       usersService.saveOrUpdate(usersPo);
       //usersService.removeById(1);
        //usersService.remove()
        return "chenggong";
    }

    @GetMapping(value = "/queryMapper")
    public List<UsersPo> queryMapper () {
        QueryWrapper<UsersPo> queryWrapper = new QueryWrapper<>();
        queryWrapper
                //.notBetween("uid",2,5);
//                 .orderBy(true,false,"uid");
//                .ge("uid","2")
//
//                .eq("username","lele");
                    .in("uid",2,3,4);
        List<UsersPo> list = usersMapper.selectList(queryWrapper);

        return list;
    }
    @GetMapping(value = "/getData")
    public Object getData(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://10.19.90.38:18102/api/kpi/queryKpiDefineList?\n" +
                "param=%7B%22teamName%22:%22nj_kpi%22,%22currPage%22:1,%22pageSize%22:10%7D";
        Object forObject = restTemplate.getForObject(url, Object.class);
        return forObject;
    }
}
