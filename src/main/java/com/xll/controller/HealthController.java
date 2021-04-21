package com.xll.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author : XuLeLe
 * @Date : 2021/01/28/14:17
 * @Description:
 */
@RestController
@RequestMapping(value = "health")
public class HealthController {

    @GetMapping(value = "/")
    public String HealthController(){

        return "health";
    }
}
