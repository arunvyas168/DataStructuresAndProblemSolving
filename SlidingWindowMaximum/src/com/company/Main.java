package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int window1 =3;
        int[] arr2 = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int window2 = 4;
        printMaxSlidingWindow(arr1,window1);
        System.out.println();
        printMaxSlidingWindow(arr2,window2);
    }


    public static void printMaxSlidingWindow(int arr[] , int windowSize){
        if(windowSize>arr.length){
            return;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int i;
        for(i=0;i<windowSize;i++){
            while ((!deque.isEmpty()) && (arr[i] >= arr[deque.getLast()])){
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for(;i<arr.length;i++){
            System.out.print(arr[deque.getFirst()]+" ");
            while ((!deque.isEmpty()) && (deque.getFirst() <= i-windowSize)){
                deque.removeFirst();
            }
            while ((!deque.isEmpty()) && (arr[i] >= arr[deque.getLast()])){
                deque.removeLast();
            }
            deque.addLast(i);
        }

        System.out.println(arr[deque.getFirst()]);

    }



/*
    //Simple way with O(n*window) complexity.

    public static void printMaxSlidingWindow(int arr[] , int windowSize){
        int startIndex = 0;
        int max;
        int endIndex = windowSize-1;
        while (endIndex < arr.length){
            max = FindMaxOf(arr,startIndex,endIndex);
            System.out.print(max+" ");
            startIndex++;
            endIndex++;
        }

    }


    public static int FindMaxOf(int[] arr ,int startIndex ,int endIndex){
        int max = arr[startIndex];
        int index = startIndex+1;
        while (index <= endIndex){
            if(max < arr[index]){
                max = arr[index];
            }
            index++;
        }
        return max;
    }
*/

}
