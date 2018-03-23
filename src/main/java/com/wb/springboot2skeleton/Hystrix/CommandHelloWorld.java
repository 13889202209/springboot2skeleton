package com.wb.springboot2skeleton.Hystrix;

import com.netflix.hystrix.*;

public class CommandHelloWorld extends HystrixCommand<String> {
    private String name;


    public CommandHelloWorld(String name) {
        super(
                Setter
                        .withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(2000))  //超时时间
                        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ExampleGroup-pool"))
                        .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10))
        );
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        Thread.sleep(1000);
        return name + "  helloworld";
    }


    @Override
    protected String getFallback() {
        return "Hello " + "Fallback";
    }
}
