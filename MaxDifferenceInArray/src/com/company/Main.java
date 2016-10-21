package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array1 = {2, 3, 10, 6, 4, 8, 1};
        int[] array2 = {1, 2, 90, 10, 110};
        int[] array3 = {80, 2, 6, 3, 100};
        System.out.println(maxDiff(array1));
        System.out.println(maxDiff(array2));
        System.out.println(maxDiff(array3));
    }


    public static int maxDiff(int [] array){
        if (array.length==0){
            return Integer.MIN_VALUE;
        }
        int[] diff = new int[array.length-1];
        for (int i=0;i<array.length-1;i++){
            diff[i] = array[i+1]-array[i];
        }
        return maxSubarraySum(diff);
    }

    public static int maxSubarraySum(int[] array){
        if (array.length == 0){
            return Integer.MIN_VALUE;
        }
        int maxSum = array[0];
        int currSum = array[0];
        for (int i=1;i<array.length;i++){
            currSum = Math.max(array[i],currSum+array[i]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }

    /*
            This method will find Maximum difference between two elements such that
            larger element appears after the smaller number
     */

    /*
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
    }*/

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
