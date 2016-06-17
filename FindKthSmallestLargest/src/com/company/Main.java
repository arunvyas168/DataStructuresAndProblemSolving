package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        int[] array = {12, 3, 17, 0, 9, 6, 100};
        //0 ,3, 6, 9, 12, 17, 100
        int k = 3;
        //Test case if k is larger than array.length
        int kThSmallestElement = findKthSmallestElement(array,k);
        System.out.println(kThSmallestElement+" found using Priority Queue");
        kThSmallestElement = quickSelectKthSmallest(array,k);
        System.out.println(kThSmallestElement+" found using QuickSelect");
    }

    public static int findKthSmallestElement(int[] array, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(Integer i : array){
            heap.offer(i);
            if(heap.size()>k){
                heap.poll();
            }
        }
        return heap.peek();
    }

    /*
        Make sure your pivot is the the element at the index which is k-1
        Partition: all elements on left is small and all element on right is larger
        We don't actually have care about the order of elements.
     */
    public static int quickSelectKthSmallest(int[] array, int k){
        int low = 0;
        int high = array.length-1;
        int pivot = array[k-1];
        partition(array,pivot,low,high);
        return array[k-1];
    }

    public static void partition(int[] array, int pivot, int low, int high){
        int leftPointer = low-1;
        int rightPointer = high;
        while (leftPointer<rightPointer){
            while (array[++leftPointer]<pivot);
            while ((rightPointer>leftPointer)&&(array[--rightPointer]>pivot));
            if(leftPointer>=rightPointer){
                break;
            }else {
                swap(array,leftPointer,rightPointer);
            }
        }
        swap(array,leftPointer,high);
    }

    public static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
