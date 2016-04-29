package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = {-3,-2,0,1,2,3};
        //assuming its sorted.
        printTripletSumToZero(array);
    }

    public static void printTripletSumToZero(int[] array){

        int current;

        for (int i = 0; i< array.length-1;i++){
            current = array[i];
            int sum = 0;
            sum = sum - current;
            int startIndex = 0;
            //int startIndex = i+1; for non repetitive.
            int endIndex = array.length-1;
            while (startIndex < endIndex){
                if (startIndex == i){
                    startIndex++;
                } else if(endIndex == i){
                    endIndex --;
                }else {
                    if (sum == array[startIndex] + array[endIndex]) {
                        System.out.println("["+array[i]+","+array[startIndex]+","+array[endIndex]+"]");
                        startIndex++;
                        endIndex--;
                    }else if (sum > array[startIndex] + array[endIndex] ){
                        startIndex++;
                    }else {
                        endIndex--;
                    }
                }
            }
        }
    }
}
