package com.wb.springboot2skeleton.Hystrix;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixCtrl {
    @GetMapping("/hystrix")
    public String test() {
        String s = new CommandHelloWorld("Bob").execute();

        System.out.println("-------------------" + s);

        return "hystrix";
    }
}
