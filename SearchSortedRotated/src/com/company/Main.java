package com.company;

public class Main {

    public static void main(String[] args) {
	    //int[] array = {4,5,6,7,0,1,2};
        //int[] array = {1,2,3,4,5,6,7};
        int[] array = {2,1};
        //int[] array = {3,4,5,6,7,0,1,2};
        //int[] array = {3,4,5,6,7,8,0,2};
        //int[] array = {4,5,6,7,1,2,3};
        int searchIndex = sortedRotatedSearch(array,1);
        if(searchIndex>=0){
            System.out.println("The key is present in the array at index: "+ searchIndex);
        } else {
            System.out.println("key is not present");
        }
    }

    public static int sortedRotatedSearch(int[] array, int key){
        return sortedRotatedSearch_Util(array,0,(array.length-1),key);
    }

    public static int sortedRotatedSearch_Util(int[] array, int startIndex, int endIndex, int key){

        if (endIndex < startIndex){
            return -1;
        }

        int midIndex = startIndex+(endIndex-startIndex/2);

        if (array[midIndex] == key){
            return midIndex;
        } else if (array[midIndex] >= array[startIndex]){
            if ((array[startIndex]<=key)&&(key < array[midIndex])){
                return sortedRotatedSearch_Util(array,startIndex,midIndex-1,key);
            } else {
                return sortedRotatedSearch_Util(array, midIndex + 1, endIndex, key);
            }
        }else {
            if ((array[midIndex] < key) && (key <= array[endIndex])) {
                return sortedRotatedSearch_Util(array, midIndex+1, endIndex, key);
            }else {
                return sortedRotatedSearch_Util(array, startIndex, midIndex-1, key);
            }
        }
    }

}
