package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = {6, -3, -10, 0, 2};
        System.out.println(findMaxProdThree(array));
    }
    public static int findMaxProdThree(int[] array){
        int len = array.length;
        if(len<3){
            return -1;
        }else if (len == 3){
            return array[0]*array[1]*array[2];
        }
        int[] maxThree = getMaxThree(array);
        int[] minTwo = getMinTwo(array);
        int product1 =  maxThree[0]*maxThree[1]*maxThree[2];
        int product2 = minTwo[0]*minTwo[1]*maxThree[0];
        return Math.max(product1,product2);
    }

    public static int[] getMaxThree(int[] array){
        int[] maxThree = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        for(int i=0;i<array.length;i++){
            if(array[i]>maxThree[0]){
                maxThree[2] = maxThree[1];
                maxThree[1] = maxThree[0];
                maxThree[0] = array[i];
            }else if(array[i]>maxThree[1]){
                maxThree[2] = maxThree[1];
                maxThree[1] = array[i];
            }else if (array[i]>maxThree[2]){
                maxThree[2] = array[i];
            }
        }
        return maxThree;
    }
    public static int[] getMinTwo(int[] array){
        int[] minTwo = {Integer.MAX_VALUE,Integer.MAX_VALUE};
        for(int i=0;i<array.length;i++){
            if(array[i]<minTwo[0]){
                minTwo[1] = minTwo[0];
                minTwo[0] = array[i];
            }else if(array[i]<minTwo[1]){
                minTwo[1] = array[i];
            }
        }
        return minTwo;
    }


    /*public static int findMaxProdThree(int[] array){
        int len = array.length;
        if(len<3){
            return -1;
        }else if (len == 3){
            return array[0]*array[1]*array[2];
        }
        int max1 = array[0];
        int max1Index = 0;
        int min1 = array[0];
        int min1Index = 0;
        for(int i=0;i<len;i++){
            if(array[i]>max1){
                max1 = array[i];
                max1Index = i;
            }
            if(array[i]<min1){
                min1 = array[i];
                min1Index = i;
            }
        }
        int max2 = min1;
        int max3 = min1;
        int min2 = max1;
        for(int i=0;i<len;i++){
            if ((i == max1Index)|| (i==min1Index)){
                continue;
            }
            if (array[i]>max2){
                max3 = max2;
                max2 = array[i];
            }else if(array[i]>max3){
                max3 = array[i];
            }
            if (array[i]<min2){
                min2 = array[i];
            }

        }

        System.out.println("Max1: "+max1);
        System.out.println("Max2: "+max2);
        System.out.println("Max3: "+max3);
        System.out.println("Min1: "+min1);
        System.out.println("Min2: "+min2);

        return Math.max((max1*max2*max3),(min1*min2*max1));

    }*/
}
