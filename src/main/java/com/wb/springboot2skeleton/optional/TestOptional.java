package com.wb.springboot2skeleton.optional;

import java.util.Optional;

public class TestOptional {

    private String name ;

    public TestOptional(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public static void main(String[] args) {
        TestOptional t = new TestOptional("wb");
        Optional<TestOptional> optional = Optional.of(t);
        Optional<String> resultOpt =  optional.map(x -> x.getName()).map(x->x.toUpperCase());
        String result = resultOpt.orElseGet(()->"aaa");

        System.out.println(result);
    }
}
