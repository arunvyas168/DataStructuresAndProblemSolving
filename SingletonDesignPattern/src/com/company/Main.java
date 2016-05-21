package com.company;

public class Main {

    public static void main(String[] args) {
        PerformanceStage per1 = PerformanceStage.getInstance();
        PerformanceStage per2 = PerformanceStage.getInstance();
        per1.setA(5);
        System.out.println(per1.getA());
        per2.setA(6);
        System.out.println(per1.getA());
        System.out.println(per1.getCounter());
        System.out.println(per2.getCounter());
    }
}
