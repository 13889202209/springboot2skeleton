package com.wb.springboot2skeleton.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebCtrl {

    @RequestMapping("birth")
    public String birth(){
        System.out.println("birth");
        return "birth";
    }



}
