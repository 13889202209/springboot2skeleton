package com.wb.springboot2skeleton.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebCtrl {

    @RequestMapping("index")
    public String hello(){
        System.out.println("index");
        return "index";
    }



}
