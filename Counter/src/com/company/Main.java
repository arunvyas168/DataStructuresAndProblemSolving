package com.company;

import java.sql.Timestamp;
import java.util.Date;

public class Main {

    static int  counterStore[];
    static Timestamp startTime;
    static Timestamp currentTime;
    static int currentIncrementIndex;
    final static int maxTime = 3600;
    final static int midTime = 1800;
    final static int minTime = 60;
    static int totalHits = 0;

    public static void main(String[] args) {
        counterStore = new int[maxTime];
        currentIncrementIndex = 0;
        Date start = new Date();
        startTime = new Timestamp(start.getTime());
        //System.out.println(startTime.toLocalDateTime().getSecond());
        //System.out.println(startTime.toLocalDateTime().getMinute());
        //System.out.println(startTime.toLocalDateTime().getHour());
        incrementCounter();
        System.out.println(getPerTime(maxTime));
        System.out.println(getPerTime(midTime));
        System.out.println(getPerTime(minTime));

    }

    public static void incrementCounter(){
        Date now = new Date();
        currentTime = new Timestamp(now.getTime());
        int difference = (int)(currentTime.getTime() - startTime.getTime())/1000;
        startTime = currentTime;
        currentIncrementIndex = getArrayIndexToIncrement(difference);
        counterStore[currentIncrementIndex] = counterStore[currentIncrementIndex]+1;
    }

    public static int getArrayIndexToIncrement(long difference){
        if ((currentIncrementIndex + difference) <= maxTime){
            for (int i = (currentIncrementIndex+1);i<difference-1;i++){
                counterStore[i] = 0;
            }
            return (int)(currentIncrementIndex + difference);
        } else {
            int remainder = (int)((currentIncrementIndex + difference) - maxTime);
            for (int i = 0;i<remainder;i++){
                counterStore[i] = 0;
            }
            return remainder;
        }
    }

    public static int getPerTime(int timeInterval){

        if ((currentIncrementIndex -timeInterval) >= 0){
            for (int i = currentIncrementIndex; i >= timeInterval; i--){
                totalHits += counterStore[i];
            }
            return totalHits;
        } else {
            for (int i = currentIncrementIndex; i >= 0; i--){
                totalHits += counterStore[i];
            }
            int remainder = timeInterval-currentIncrementIndex;
            for (int i = maxTime; i<remainder;i--){
                totalHits += counterStore[i];
            }
            return totalHits;
        }
    }



}
