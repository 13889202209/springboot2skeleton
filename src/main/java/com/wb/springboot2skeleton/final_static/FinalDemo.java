package com.wb.springboot2skeleton.final_static;

public class FinalDemo {

    private static final String A;
    private static final String A1 = "static final直接赋值";

    private  final String B;
    private  final String B1 = "final直接赋值";

    static {
        A= "静态初始化块初始化";
    }

//    {
//        B= "初始化块初始化";
//    }

    public FinalDemo(String b) {

        B = b;
    }

    public static void main(String[] args) {
        FinalDemo demo1 = new FinalDemo("构造方法初始化demo1");
        System.out.println(demo1.B);
        FinalDemo demo2 = new FinalDemo("构造方法初始化demo2");
        System.out.println(demo2.B);

        System.out.println(FinalDemo.A);
        System.out.println(FinalDemo.A1);

    }

}