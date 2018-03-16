package com.wb.springboot2skeleton.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

public class TestStream {

    private String name ;

    public TestStream(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        List<TestStream> l = new ArrayList<TestStream>();
        PrimitiveIterator.OfInt iter =   IntStream.rangeClosed(0, 10000000).iterator();
        while (iter.hasNext()){
            l.add(new TestStream(iter.next().toString()));
        }
        long start = System.currentTimeMillis();
//        l.stream()/*.parallel()*/.forEach(x -> x.getName().split(""));
        for(TestStream x : l){
            x.getName().split("");
        }
        System.out.println("end   " + (System.currentTimeMillis() - start));
    }

}
