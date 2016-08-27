package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = {4,5,6,7,0,1,2};
        //int[] array = {1,2,3,4,5,6,7};
        //int[] array = {5,6,7,0,1,2,3};
        //int[] array = {3,4,5,6,7,0,1,2};
        //int[] array = {3,4,5,6,7,8,0,2};
        //int[] array = {4,5,6,7,1,2,3};
        System.out.println("The Min element in the sorted Rotated Array is: "+ sortedRotatedSearch(array));
    }

    public static int sortedRotatedSearch(int[] array){
        return sortedRotatedSearch_Util(array,0,(array.length-1));
    }

    public static int sortedRotatedSearch_Util(int[] array, int startIndex, int endIndex) {

        //If array is not rotated at all;
        if(array[endIndex]>array[startIndex]){
            return array[startIndex];
        }
        //If there is just 1 element left
        if (startIndex == endIndex){
            return array[startIndex];
        }

        int midIndex = startIndex + (endIndex-startIndex)/2;

        // Check if element (mid+1) is minimum element. Consider
        // the cases like {3, 4, 5, 1, 2}
        if ((midIndex < endIndex) && (array[midIndex] > array[midIndex+1])){
            return array[midIndex+1];
        }
        // Check if mid itself is minimum element
        if ((midIndex > startIndex) && (array[midIndex] < array[midIndex-1])){
            return array[midIndex];
        }
        //If all condition fails we recursively try to hit the condition
        if (array[endIndex] > array[midIndex]){
            return sortedRotatedSearch_Util(array,startIndex,midIndex-1);
        } else {
            return sortedRotatedSearch_Util(array,midIndex+1,endIndex);
        }
    }
}
