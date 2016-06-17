package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = {10, 80, 30, 90, 40, 50, 70};
        System.out.printf("The initial array is: [");
        for(int i :array){
            System.out.print(i + " ");
        }
        System.out.println("]");
        quickSort(array,0,array.length-1);
        System.out.printf("The sorted array is: [");
        for(int i :array){
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

    public static void quickSort(int[] array, int low,int high){
        if(low>=high){
            return;
        }
        int partition = PartitioningArray(array,array[high],low,high);
        quickSort(array,low,partition-1);
        quickSort(array,partition+1,high);
    }


    public static int PartitioningArray(int[] array, int pivot, int low, int high){
        int leftPointer = low-1;
        int rightPointer = high;

        while (leftPointer<rightPointer){

            while (array[++leftPointer]<pivot);
            while ((rightPointer>0)&&(array[--rightPointer]>pivot));
            if(leftPointer>=rightPointer){
                break;
            }else {
                swap(array, leftPointer, rightPointer);
            }
        }
        swap(array,leftPointer,high);
        return leftPointer;
    }

    public static void swap(int[] array,int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
