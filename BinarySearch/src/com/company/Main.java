package com.company;

public class Main {

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,7,8,9,10,14};
        int keyIndex = binarySearch(array,14);
        if ( keyIndex >= 0){
            System.out.println("Array has the key at index: "+ keyIndex);
        } else{
            System.out.println("Key not present");
        }
    }

    public static int binarySearch(int[] array , int key){
        return binarySearch_util(array, 0,(array.length-1),key);
    }

    public static int binarySearch_util(int[] array, int startIndex, int endIndex, int key){
        if(endIndex<startIndex){
            return -1;
        }
        int mid = (startIndex + endIndex) / 2;
        if (array[mid] == key) {
            return mid;
        } else if (key < array[mid]) {
            return binarySearch_util(array, startIndex, mid-1, key);
        } else {
            return binarySearch_util(array, mid+1, endIndex, key);
        }
    }
}
