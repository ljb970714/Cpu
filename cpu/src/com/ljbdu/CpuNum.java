package com.ljbdu;

public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int cpuNums = runtime.availableProcessors();
        System.out.println("当前cpu总数:" + cpuNums);


    }
}
