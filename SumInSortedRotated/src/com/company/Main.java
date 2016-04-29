package com.company;

public class Main {

    public static void main(String[] args) {
        //int[] arr = {6,7,1,2,3,4};
        int[] arr = {1,2,3,4,6,7};
        int sum  = 10;
        if (isSumPresentInSortedRotated(arr,sum)){
            System.out.println("Yes, The sum is present");
        } else {
            System.out.println("No, the sum is not present");
        }
    }

    /* Perfect solution:
    public static boolean isSumPresentInSortedRotated(int[] arr, int sum){
        //Find Min and max
        int i;
        System.out.println(arr.length-1);
        for(i = 0; i <(arr.length-1); i++ ){
            System.out.println(i);
            if(arr[i] > arr[i+1]){
                break;
            }
        }
        int endIndex = i;
        int startIndex = (i+1)%(arr.length-1);

        while (endIndex!=startIndex){
            if ((arr[endIndex]+arr[startIndex]) < sum){
                startIndex = (startIndex+1)%arr.length;
            } else if((arr[endIndex]+arr[startIndex]) > sum){
                endIndex = (arr.length+endIndex-1)%arr.length;
            }else {
                return true;
            }
        }
        return false;
    }*/

    /* My solution with lot of conditions: */
    public static boolean isSumPresentInSortedRotated(int[] arr, int sum) {
        //Find Min and max
        int i;
        int startIndex;
        int endIndex;

        for (i = 0; i < (arr.length-1); i++) {
            if (arr[i] > arr[i + 1]) {
                break;
            }
        }
        if(i == (arr.length-1)){
            startIndex = 0;
            endIndex = arr.length-1;
        } else {
            startIndex = i+1;
            endIndex = i;
        }

        while (endIndex != startIndex){
            if ((arr[startIndex]+arr[endIndex]) == sum){
                return true;
            } else if((arr[startIndex]+arr[endIndex]) < sum){
                if (startIndex == arr.length-1){
                    startIndex = 0;
                } else {
                    startIndex++;
                }
            } else {
                if (endIndex == 0){
                    endIndex = arr.length-1;
                } else {
                    endIndex--;
                }
            }
        }
        return false;
    }

}
