package com.company;

/*
    Reverse an array in subset of N. Example:
    input: Array = [1,2,3,4,5,6,7,8,9], N = 3
    output: [3,2,1,6,5,4,9,8,7]
 */

public class Main {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        int k = 3;
        reverseInSubsetWindow(array,k);
        for (int i : array){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void reverseInSubsetWindow(int[]array, int window){
        int start = 0;
        while ((start+window-1)<array.length){
            reverse(array,start,start+window-1);
            start = start+window;
        }
        if (start!=array.length-1){
            reverse(array,start,array.length-1);
        }
    }

    public static void reverse(int[] array, int start, int end){
        while (start<end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

}
