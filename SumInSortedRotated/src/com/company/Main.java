package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = {6,7,1,2,3,4};
        int sum  = 5;
        if (isSumPresentInSortedRotated(arr,sum)){
            System.out.println("Yes, The sum is present");
        } else {
            System.out.println("No, the sum is not present");
        }
    }

    public static boolean isSumPresentInSortedRotated(int[] arr, int sum){
        //Find Min and max
        int i;
        for(i = 0; i <(arr.length-1); i++ ){
            if(arr[i] > arr[i+1]){
                break;
            }
        }
        int endIndex = i;
        int startIndex = (i+1)%(arr.length-1);
        System.out.println(endIndex);
        System.out.println(arr.length-1);
        System.out.println(startIndex);
        return true;
    }
}
