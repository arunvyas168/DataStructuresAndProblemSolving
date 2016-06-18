package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array1 = {2, 3, 10, 6, 4, 8, 1};
        int[] array2 = {7, 9, 5, 6, 3, 2};
        System.out.println(maxDiff(array1));
        System.out.println(maxDiff(array2));
    }
    /*
            This method will find Maximum difference between two elements such that
            larger element appears after the smaller number
     */

    public static int maxDiff(int[] array){
        int maxDifference = array[1]-array[0];
        int min = array[0];
        for(int i=0;i<array.length;i++){
            if((array[i]-min)>maxDifference){
                maxDifference = array[i]-min;
            }
            if(array[i]<min){
                min = array[i];
            }
        }
        return maxDifference;
    }


     /*
    This Method will find difference between smallest and the largest element in the array.
     */
    /*public static int maxDiff(int[] array){
        int min = array[0];
        int max = array[0];
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                max = array[i];
            }
            if(array[i]<min){
                min = array[i];
            }
        }
        return max-min;
    }*/


}
