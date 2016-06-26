package com.company;

public class Main {

    public static void main(String[] args) {
	    int array[] = {10, 3, 5, 6, 2};
        int [] result = productArray(array);
        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
        int product[] = productArrayWithExtraSpace(array);
        for(int i:product){
            System.out.print(i+" ");
        }
    }

    /*
        Most efficient way with O(n)time complexity and O(1) space.
    */
    public static int[] productArray(int[] array) {
        int[] result = new int[array.length];

        result[array.length-1]=1;
        for(int i=array.length-2; i>=0; i--){
            result[i]=result[i+1]*array[i+1];
        }

        int left=1;
        for(int i=0; i<array.length; i++){
            result[i]=result[i]*left;
            left = left*array[i];
        }
        return result;
    }

     /*
        Most efficient way with O(n)time complexity and O(N) space.
    */
     public static int[] productArrayWithExtraSpace(int[] array) {
         int[] result = new int[array.length];
         int[] left = new int[array.length];
         int[] right = new int[array.length];

         left[0] = 1;
         right[array.length-1]=1;

         for(int i=1;i<array.length;i++){
             left[i] = left[i-1]*array[i-1];
         }

         for (int i=array.length-2;i>=0;i--){
             right[i] = right[i+1]*array[i+1];
         }
         for (int i=0;i<array.length;i++){
             result[i] = left[i]*right[i];
         }
         return result;
     }

}
