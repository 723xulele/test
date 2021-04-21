package com.xll.controller;

import com.xll.entity.po.AnimalPo;
import com.xll.entity.po.UsersPo;
import com.xll.mapper.AnimalMapper;
import com.xll.mapper.TestMapper;
import com.xll.service.AnimalService;
import com.xll.service.UsersService;
import org.apache.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author : XuLeLe
 * @Date : 2021/01/27/17:39
 * @Description:
 */
@RestController
@RequestMapping(value = "AnimalInfo")
public class AnimalController {

    @Resource
    private AnimalMapper animalMapper;
    @Resource
    private UsersService usersService;
    @Resource
    private TestMapper testMapper;

    @GetMapping(value = "/getAllAnimalPo")
    public List<AnimalPo> getAllAnimalPo(){
        System.out.println(11111);
        List<AnimalPo> animalPos = animalMapper.selectList(null);
        System.out.println(2222);
        return animalPos;
    }

    @GetMapping(value = "/getAnimalByAid")
        public AnimalPo getAnimalByAid (int a) {
            AnimalPo animalPo = animalMapper.selectById(a);
            return animalPo;
    }

    @GetMapping(value = "/getUserByUid")
    public UsersPo getUserByUid (int uid ) {
        UsersPo usersPo = usersService.getById(uid);
        return usersPo;
    }

    @GetMapping(value = "/getAllUsers")
    public List<UsersPo> getAllUsers () {
        List<UsersPo> list = usersService.list();
        return list;
    }

    @GetMapping(value = "/testGetAllUsers")
    public List<UsersPo> testGetAllUsers () {
        List<UsersPo> list = testMapper.testGetAllUsers();
        return list;
    }

    @RequestMapping(value = "/getUserSession", method = RequestMethod.GET)
    public Object getUserSession(String userId, HttpServletRequest request) {
        System.out.println(userId != "");
        if (userId != "" || userId == null || userId == "#/") {
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            String user = session.getAttribute("userId").toString();
            System.out.println(user);
            return 200;
        } else {
            return HttpStatus.SC_BAD_REQUEST;
        }
    }

    @RequestMapping(value = "/getSession", method = RequestMethod.GET)
    public String getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = session.getAttribute("userId").toString();
        return userId;
    }
}

