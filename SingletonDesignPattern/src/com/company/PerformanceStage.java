package com.company;

/**
 * Created by arun on 5/20/16.
 */
public class PerformanceStage {

    private static PerformanceStage instance = null;
    private static int counter = 0;
    private PerformanceStage(){
        counter++;
    }
    private int a;

    public synchronized static PerformanceStage getInstance(){
        if(instance == null ){
            instance = new PerformanceStage();
        }
        return instance;
    }
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getCounter() {
        return counter;
    }
}
